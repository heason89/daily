package com.example.daily.vo;

public class ExtractEmailTokenRes extends BasicRes{

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ExtractEmailTokenRes() {
    }

    public ExtractEmailTokenRes(int code, String message) {
        super(code, message);
    }

    public ExtractEmailTokenRes(int code, String message, String email) {
        super(code, message);
        this.email = email;
    }
}
