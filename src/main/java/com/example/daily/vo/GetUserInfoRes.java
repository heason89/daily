package com.example.daily.vo;

import com.example.daily.dto.UserDto;

public class GetUserInfoRes extends BasicRes{

    private UserDto user;

    public GetUserInfoRes(int code, String message) {
        super(code, message);
    }

    public GetUserInfoRes(int code, String message, UserDto user) {
        super(code, message);
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }
}
