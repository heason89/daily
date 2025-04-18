package com.example.daily.controller;

import com.example.daily.service.ifs.UserService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.LoginReq;
import com.example.daily.vo.RegisterReq;
import com.example.daily.vo.UpdateUserReq;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
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
}
