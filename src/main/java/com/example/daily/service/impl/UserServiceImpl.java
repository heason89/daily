package com.example.daily.service.impl;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.UserDao;
import com.example.daily.dto.UserDto;
import com.example.daily.entity.User;
import com.example.daily.service.ifs.EmailService;
import com.example.daily.service.ifs.UserService;
import com.example.daily.util.JwtUtil;
import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public LoginRes login(LoginReq req) {
        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(req.getEmail());
        // 呼叫 checkmail 檢查
        BasicRes res = checkmail(userEmail);
        if(res.getCode()==400){
            return new LoginRes(res.getCode(),res.getMessage());
        }
        // 檢查帳號密碼
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(req.getPassword(), userEmail.getPassword())){
            return new LoginRes(ResMessage.PASSWORD_MISMATCH.getCode(),//
                    ResMessage.PASSWORD_MISMATCH.getMessage());
        }
        // 取得 userId 及 version
        int userId = userEmail.getUserId();
        int version = userEmail.getVersion()+1;
        // 更新 version
        userDao.updateVersion(userId,version);
        // 產生登入用token
        String token = jwtUtil.generateLoginToken(userId, version);
        return new LoginRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage(),token,userEmail.isAdmin());
    }

    @Override
    public BasicRes logout(LogoutReq req) {
        String token = req.getToken();
        // 解析 token
        ExtractUserTokenRes res = jwtUtil.extractUserToken(token);
        if(res.getCode()!=200)
        {
            return new BasicRes(res.getCode(),res.getMessage());
        }
        // 取得 userId 及 version
        int userId = res.getUserId();
        int version = res.getVersion()+1;
        // 更新 version
        userDao.updateVersion(userId,version);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes register(RegisterReq req) {
        // 檢查 email 格式

        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(req.getEmail());
        // email 已存在且啟用中
        if (userEmail != null && userEmail.isEnable()){
            return new BasicRes(ResMessage.EMAIL_EXISTED.getCode(),//
                    ResMessage.EMAIL_EXISTED.getMessage());
        }
        // 將 password 變成亂碼
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(req.getPassword());
        // 生成 token
        String token = jwtUtil.generateRegisterToken(req.getEmail());
        //  email 已存在但未啟用
        if (userEmail != null && !userEmail.isEnable()){
            // 改用更新的方式處理
            userDao.updateNotEnableEmail(req.getName(),req.getEmail(),encodePassword,req.isAdmin(),
                    req.isEnable(),req.getBirthdate(),req.getHeight(),req.getWeight(),
                    req.getWorkType(),req.getGender(),
                    req.getPhoto(), req.getNote(), req.getBodyType(),1);
            emailService.sendVerificationEmail(req.getEmail(),token);
            return new BasicRes(ResMessage.SUCCESS.getCode(),//
                    ResMessage.SUCCESS.getMessage());
        }
        // 新增資訊
        userDao.insert(req.getName(),req.getEmail(),encodePassword,req.isAdmin(),req.isEnable()
                ,req.getBirthdate(),req.getHeight(),req.getWeight(),req.getWorkType(),
                req.getGender(),req.getPhoto(), req.getNote(), req.getBodyType(),1);
        emailService.sendVerificationEmail(req.getEmail(),token);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes updateUserInfo(UpdateUserReq req) {
        // 驗證 token 是否有效 及 解析出 userId 及 version
        ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
        if(res.getCode()!=200)
        {
            return new GetUserInfoRes(res.getCode(),res.getMessage());
        }
        // 取得 userId 及 version
        int userId = res.getUserId();
        int version = res.getVersion();
        // 取得 userinfo
        User userInfo =userDao.getByUserId(userId);
        // 建立加密物件
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = req.getPassword();
        // 檢查密碼是否與之前相同
        if(!req.getPassword().equals(userInfo.getPassword())){
            // 將 password 變成亂碼
            encodePassword = encoder.encode(req.getPassword());
            version++;
        }
        // 更新資訊
        userDao.updateUserInfo(userId,req.getToken(),encodePassword,req.isAdmin(),req.isEnable()
                ,req.getBirthdate(),req.getHeight(),req.getWeight(),req.getWorkType()
                ,req.getGender(),req.getPhoto(),req.getNote(), req.getBodyType(),version);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes sendResetPasswordEmail(SendEmailReq req) {
        // 檢查 email 是否已存在
        User userEmail =userDao.getByEmail(req.getToken());
        // 呼叫 checkmail 檢查
        BasicRes res = checkmail(userEmail);
        if(res.getCode()==400){
            return res;
        }
        String token = jwtUtil.generateResetPasswordToken(req.getToken());
        emailService.sendResetPasswordEmail(req.getToken(), token);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes verifyTokenUpdatePassword(ResetPasswordReq req) {
        // 驗證 token 是否有效 及 解析出 email
        ExtractEmailTokenRes res = jwtUtil.extractEmailToken(req.getToken());
        if (res.getCode()!=200)
        {
            return new BasicRes(res.getCode(),res.getMessage());
        }
        // 將 password 變成亂碼
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(req.getPassword());
        // 取得 version
        int version = userDao.getByEmail(res.getEmail()).getVersion()+1;
        // 更新 user 的密碼及version
        userDao.resetPassword(res.getEmail(),encodePassword,version);
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public GetUserInfoRes getUserInfo(GetUserDataReq req) {
        // 驗證 token 是否有效 及 解析出 userId
        ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
        if(res.getCode()!=200)
        {
            return new GetUserInfoRes(res.getCode(),res.getMessage());
        }
        // 取得 userId
        int userId = res.getUserId();
        // 取得 userinfo
        User userInfo = userDao.getByUserId(userId);
        UserDto user = new UserDto(userInfo.getName(),userInfo.getEmail(),userInfo.getBirthdate(),
                userInfo.getHeight(),userInfo.getWeight(),userInfo.getWorkType(),userInfo.getGender(),
                userInfo.getPhoto(),userInfo.getNote(),userInfo.getBodyType());

        return new GetUserInfoRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage(),user);
    }

    @Override
    public BasicRes verifyToken(VerifyTokenReq req) {
        // 驗證 token 是否有效 及 解析出 email
        ExtractEmailTokenRes res = jwtUtil.extractEmailToken(req.getToken());
        if (res.getCode()!=200)
        {
            return new BasicRes(res.getCode(),res.getMessage());
        }
        // 更新 user 的帳號狀態
        userDao.updateEnable(res.getEmail());
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
        if (!usermail.isEnable()){
            return new BasicRes(ResMessage.EMAIL_HAS_BEEN_CANCELED.getCode(),//
                    ResMessage.EMAIL_HAS_BEEN_CANCELED.getMessage());
        }
        return new BasicRes(ResMessage.SUCCESS.getCode(),//
                ResMessage.SUCCESS.getMessage());
    }
}
