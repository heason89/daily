package com.example.daily.service.impl;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.UserDao;
import com.example.daily.entity.User;
import com.example.daily.service.ifs.UserService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.LoginReq;
import com.example.daily.vo.RegisterReq;
import com.example.daily.vo.UpdateUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public BasicRes login(LoginReq req) {
        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(req.getEmail());
        // 帳號不存在
        if (userEmail == null){
            return new BasicRes(ResMessage.EMAIL_NOT_EXISTED.getCode(),//
                    ResMessage.EMAIL_NOT_EXISTED.getMessage());
        }
        // 帳號已註銷
        if (!userEmail.isActive()){
            return new BasicRes(ResMessage.EMAIL_HAS_BEEN_CANCELED.getCode(),//
                    ResMessage.EMAIL_HAS_BEEN_CANCELED.getMessage());
        }
        // 檢查帳號密碼
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(req.getPassword(), userEmail.getPassword())){
            return new BasicRes(ResMessage.PASSWORD_MISMATCH.getCode()//
                    , ResMessage.PASSWORD_MISMATCH.getMessage());
        }
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes register(RegisterReq req) {
        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(req.getEmail());
        // email 已存在且啟用中
        if (userEmail != null && userEmail.isActive()){
            return new BasicRes(ResMessage.EMAIL_EXISTED.getCode(),//
                    ResMessage.EMAIL_EXISTED.getMessage());
        }
        // 將 password 變成亂碼
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(req.getPassword());
        //  email 已存在但未啟用
        if (userEmail != null && !userEmail.isActive()){
            userDao.updateUser(req.getName(),req.getEmail(),encodePassword,req.isAdmin(),req.isActive()
                    ,req.getAge(),req.getHeight(),req.getWeight(),req.getWorkType(),req.isGender());
            return new BasicRes(ResMessage.SUCCESS.getCode(),//
                    ResMessage.SUCCESS.getMessage());
        }
        // 新增資訊
        userDao.insert(req.getName(),req.getEmail(),encodePassword,req.isAdmin(),req.isActive()
                ,req.getAge(),req.getHeight(),req.getWeight(),req.getWorkType(),req.isGender());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes updateUserInfo(UpdateUserReq req) {
        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(req.getEmail());
        // 帳號不存在
        if (userEmail == null){
            return new BasicRes(ResMessage.EMAIL_NOT_EXISTED.getCode(),//
                    ResMessage.EMAIL_NOT_EXISTED.getMessage());
        }
        // 帳號已註銷
        if (!userEmail.isActive()){
            return new BasicRes(ResMessage.EMAIL_HAS_BEEN_CANCELED.getCode(),//
                    ResMessage.EMAIL_HAS_BEEN_CANCELED.getMessage());
        }
        // 將 password 變成亂碼
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(req.getPassword());
        // 更新資訊
        userDao.updateUser(req.getName(),req.getEmail(),encodePassword,req.isAdmin(),req.isActive()
                ,req.getAge(),req.getHeight(),req.getWeight(),req.getWorkType(),req.isGender());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }
}
