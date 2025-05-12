package com.example.daily.vo;

public class ExtractUserTokenRes extends BasicRes{

    private int userId;

    private int version;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public ExtractUserTokenRes() {
    }

    public ExtractUserTokenRes(int code, String message) {
        super(code, message);
    }

    public ExtractUserTokenRes(int code, String message, int userId, int version) {
        super(code, message);
        this.userId = userId;
        this.version = version;
    }
}
