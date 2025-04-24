package com.example.daily.controller;

import com.example.daily.service.ifs.UserService;
import com.example.daily.vo.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class UserServiceController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "daily/login")
    public BasicRes login(@Valid @RequestBody LoginReq req){
        return userService.login(req);
    }

    @PostMapping(value = "daily/register")
    public BasicRes register(@Valid @RequestBody RegisterReq req){
        return userService.register(req);
    }

    @PostMapping(value = "daily/update_user")
    public BasicRes updateUser(@Valid @RequestBody UpdateUserReq req){
        return userService.updateUserInfo(req);
    }

    @PostMapping(value = "daily/get_user_info")
    public GetUserInfoRes getUserInfo(@RequestBody GetUserInfoReq req){
        return userService.getUserInfo(req);
    }

    @GetMapping("daily/verify")
    public BasicRes verify(@RequestParam("token") String token) {
        return userService.verifyToken(token);
    }

    // 下面兩個可能還要調整
    // 請求寄送重設密碼信
    @PostMapping("daily/send_reset_password")
    public BasicRes sendResetPasswordEmail(@RequestParam String email) {
        return userService.sendResetPasswordEmail(email);
    }
    // 傳入 token 與新密碼，重設密碼
    @PostMapping("daily/reset_password")
    public BasicRes updatePassword(@RequestParam String token,
                                  @RequestParam String newPassword) {
        return userService.verifyTokenUpdatePassword(token, newPassword);
    }

    @PostMapping("/daily/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("請選擇圖片");
        }
        String fileName = file.getOriginalFilename();
        // 儲存圖片的邏輯
        return ResponseEntity.ok("圖片上傳成功: " + fileName);
    }
}
