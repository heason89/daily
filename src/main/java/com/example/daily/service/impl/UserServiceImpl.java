package com.example.daily.service.impl;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.UserDao;
import com.example.daily.entity.User;
import com.example.daily.service.ifs.EmailService;
import com.example.daily.service.ifs.UserService;
import com.example.daily.util.JwtUtil;
import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public BasicRes login(LoginReq req) {
        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(req.getEmail());
        // 呼叫 checkmail 檢查
        BasicRes res = checkmail(userEmail);
        if(res.getCode()==400){
            return res;
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
        // 生成 token
        String token = jwtUtil.generateVerificationToken(req.getEmail());
        //  email 已存在但未啟用
        if (userEmail != null && !userEmail.isActive()){
            // 改用更新的方式處理
            userDao.updateUserAndToken(req.getName(),req.getEmail(),encodePassword,req.isAdmin(),
                    req.isActive(),req.getBirthdate(),req.getHeight(),req.getWeight(),
                    req.getWorkType(),req.getGender(),token,
                    req.getPhoto(), req.getNote(), req.getBodyType());
            emailService.sendVerificationEmail(req.getEmail(),token);
            return new BasicRes(ResMessage.SUCCESS.getCode(),//
                    ResMessage.SUCCESS.getMessage());
        }
        // 新增資訊
        userDao.insert(req.getName(),req.getEmail(),encodePassword,req.isAdmin(),req.isActive()
                ,req.getBirthdate(),req.getHeight(),req.getWeight(),req.getWorkType(),
                req.getGender(),token,req.getPhoto(), req.getNote(), req.getBodyType());
        emailService.sendVerificationEmail(req.getEmail(),token);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes updateUserInfo(UpdateUserReq req) {
        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(req.getEmail());
        // 呼叫 checkmail 檢查
        BasicRes res = checkmail(userEmail);
        if(res.getCode()==400){
            return res;
        }
        // 建立加密物件
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = req.getPassword();
        // 檢查密碼是否與之前相同
        if(!req.getPassword().equals(userEmail.getPassword())){
            // 將 password 變成亂碼
            encodePassword = encoder.encode(req.getPassword());
        }
        // 更新資訊
        userDao.updateUserInfo(req.getName(),req.getEmail(),encodePassword,req.isAdmin(),req.isActive()
                ,req.getBirthdate(),req.getHeight(),req.getWeight(),req.getWorkType()
                ,req.getGender(),req.getPhoto(),req.getNote(), req.getBodyType());
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes sendResetPasswordEmail(String email) {
        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(email);
        // 呼叫 checkmail 檢查
        BasicRes res = checkmail(userEmail);
        if(res.getCode()==400){
            return res;
        }
        String token = jwtUtil.generateResetPasswordToken(email);
        emailService.sendResetPasswordEmail(email, token);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes verifyTokenUpdatePassword(String token, String newPassword) {
        // 呼叫 checktoken 檢查 token
        BasicRes res = checktoken(token);
        if(res.getCode()==400){
            return res;
        }
        // 將 password 變成亂碼
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(newPassword);
        // 更新 user 的密碼
        userDao.resetPassword(jwtUtil.extractEmail(token),encodePassword);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public GetUserInfoRes getUserInfo(GetUserInfoReq req) {
        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(req.getEmail());
        // 呼叫 checkmail 檢查
        BasicRes res = checkmail(userEmail);
        if(res.getCode()==400){
            return new GetUserInfoRes(res.getCode(),res.getMessage());
        }
        return new GetUserInfoRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage(),userEmail);
    }

    @Override
    public BasicRes verifyToken(String token) {
        // 呼叫 checktoken 檢查 token
        BasicRes res = checktoken(token);
        if(res.getCode()==400){
            return res;
        }
        // 更新 user 的帳號狀態
        userDao.updateActive(jwtUtil.extractEmail(token));
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    private BasicRes checkmail(User usermail){
        // 帳號不存在
        if (usermail == null){
            return new BasicRes(ResMessage.EMAIL_NOT_EXISTED.getCode(),//
                    ResMessage.EMAIL_NOT_EXISTED.getMessage());
        }
        // 帳號已註銷
        if (!usermail.isActive()){
            return new BasicRes(ResMessage.EMAIL_HAS_BEEN_CANCELED.getCode(),//
                    ResMessage.EMAIL_HAS_BEEN_CANCELED.getMessage());
        }
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    private BasicRes checktoken(String token){
        // 驗證 token 是否有效
        if (!jwtUtil.isTokenValid(token)) {
            return new BasicRes(ResMessage.TOKEN_EXPIRED.getCode(),
                    ResMessage.TOKEN_EXPIRED.getMessage());
        }
        // 從 JWT 中解析出 email
        String email = jwtUtil.extractEmail(token);
        // 從資料庫找出這個 email 的使用者
        User user = userDao.getByEmail(email);
        if (user == null) {
            return new BasicRes(ResMessage.EMAIL_NOT_EXISTED.getCode(),
                    ResMessage.EMAIL_NOT_EXISTED.getMessage());
        }
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }
}
