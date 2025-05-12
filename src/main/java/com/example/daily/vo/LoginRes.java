package com.example.daily.vo;

public class LoginRes extends BasicRes{

    private boolean admin;

    private String token;

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginRes() {
    }

    public LoginRes(int code, String message) {
        super(code, message);
    }

    public LoginRes(int code, String message, String token, boolean admin) {
        super(code, message);
        this.token = token;
        this.admin = admin;
    }
}
