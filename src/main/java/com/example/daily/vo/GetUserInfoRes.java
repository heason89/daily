package com.example.daily.vo;

import com.example.daily.entity.User;


public class GetUserInfoRes extends BasicRes{

    private User user;

    public GetUserInfoRes(int code, String message) {
        super(code, message);
    }

    public GetUserInfoRes(int code, String message, User user) {
        super(code, message);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
