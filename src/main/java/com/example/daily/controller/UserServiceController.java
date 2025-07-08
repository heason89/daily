package com.example.daily.controller;

import com.example.daily.service.ifs.UserService;
import com.example.daily.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Tag(name = "User APIs", description = "與使用者帳號相關的操作")
public class UserServiceController {

    @Autowired
    private UserService userService;

    @Operation(summary = "登入", description = "使用帳號密碼登入")
    @PostMapping(value = "daily/login")
    public LoginRes login(@Valid @RequestBody LoginReq req){
        return userService.login(req);
    }

    @Operation(summary = "註冊", description = "建立新帳號")
    @PostMapping(value = "daily/register")
    public BasicRes register(@Valid @RequestBody RegisterReq req){
        return userService.register(req);
    }

    @Operation(summary = "更新使用者資訊", description = "更新名稱、密碼等個人資料")
    @PostMapping(value = "daily/update_user")
    public BasicRes updateUser(@Valid @RequestBody UpdateUserReq req){
        return userService.updateUserInfo(req);
    }

    @Operation(summary = "取得使用者資訊", description = "根據 token 取得個人資料")
    @PostMapping(value = "daily/get_user_info")
    public GetUserInfoRes getUserInfo(@Valid @RequestBody GetUserDataReq req){
        return userService.getUserInfo(req);
    }

    @Operation(summary = "驗證註冊的 Token 並更新帳號狀態", description = "確認 token 是否有效並設定帳號狀態")
    @PostMapping("daily/verify")
    public BasicRes verify(@Valid @RequestBody VerifyTokenReq req) {
        return userService.verifyToken(req);
    }

    @Operation(summary = "寄送重設密碼信", description = "傳送驗證信到使用者信箱")
    @PostMapping("daily/send_reset_password")
    public BasicRes sendResetPasswordEmail(@Valid @RequestBody SendEmailReq req) {
        return userService.sendResetPasswordEmail(req);
    }

    @Operation(summary = "驗證重設密碼的 Token 並重設密碼", description = "驗證 token 是否有效並設定新密碼")
    @PostMapping("daily/reset_password")
    public BasicRes updatePassword(@Valid @RequestBody ResetPasswordReq req) {
        return userService.verifyTokenUpdatePassword(req);
    }

    @Operation(summary = "登出", description = "將目前登入獲得的 token 失效")
    @PostMapping("daily/logout")
    public BasicRes logout(@Valid @RequestBody LogoutReq req) {
        return userService.logout(req);
    }

    @Operation(summary = "更新體重", description = "記錄體重")
    @PostMapping("daily/update_weight")
    public BasicRes updateWeight(@Valid @RequestBody WeightReq req) {
        return userService.updateWeight(req);
    }
}
