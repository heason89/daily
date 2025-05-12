package com.example.daily.controller;

import com.example.daily.service.ifs.UserService;
import com.example.daily.vo.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class UserServiceController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "daily/login")
    public LoginRes login(@Valid @RequestBody LoginReq req, HttpSession session){
        return userService.login(req);
    }

    @PostMapping(value = "daily/register")
    public BasicRes register(@Valid @RequestBody RegisterReq req){
        return userService.register(req);
    }

    @PostMapping(value = "daily/update_user")
    public BasicRes updateUser(@Valid @RequestBody UpdateUserReq req, HttpSession session){
        return userService.updateUserInfo(req);
    }

    @PostMapping(value = "daily/get_user_info")
    public GetUserInfoRes getUserInfo(@Valid @RequestBody GetUserDataReq req){
        return userService.getUserInfo(req);
    }

    @PostMapping("daily/verify")
    public BasicRes verify(@Valid @RequestBody VerifyTokenReq req) {
        return userService.verifyToken(req);
    }

    // 下面兩個可能還要調整
    // 請求寄送重設密碼信
    @PostMapping("daily/send_reset_password")
    public BasicRes sendResetPasswordEmail(@Valid @RequestBody SendEmailReq req) {
        return userService.sendResetPasswordEmail(req);
    }
    // 傳入 token 與新密碼，重設密碼
    @PostMapping("daily/reset_password")
    public BasicRes updatePassword(@Valid @RequestBody ResetPasswordReq req) {
        return userService.verifyTokenUpdatePassword(req);
    }

    @PostMapping("daily/logout")
    public BasicRes logout(@Valid @RequestBody LogoutReq req) {
        return userService.logout(req);
    }
}
