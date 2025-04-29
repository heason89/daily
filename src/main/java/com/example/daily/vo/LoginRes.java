package com.example.daily.vo;

public class LoginRes extends BasicRes{

    private boolean admin;

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public LoginRes() {
    }

    public LoginRes(int code, String message) {
        super(code, message);
    }

    public LoginRes(int code, String message, boolean admin) {
        super(code, message);
        this.admin = admin;
    }
}
