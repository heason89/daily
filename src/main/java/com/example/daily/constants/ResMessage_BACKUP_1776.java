package com.example.daily.constants;

public enum ResMessage {

    SUCCESS(200,"Success!"),//
    EMAIL_NOT_EXISTED(400,"Email not existed!"),//
    EMAIL_EXISTED(400,"Email existed!"),//
    EMAIL_HAS_BEEN_CANCELED(400,"Email has been canceled!"),//
    PASSWORD_MISMATCH(400,"Password mismatch!"),//
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
    PARAM_DATE_TIME_ERROR(400,"param date time error"),// 開始時間 > 結束時間
    EMAIL_DUPLICATED(400, "Email duplicated!!"),//email重複
>>>>>>> Stashed changes
=======
    PARAM_DATE_TIME_ERROR(400,"param date time error"),// 開始時間 > 結束時間
    EMAIL_DUPLICATED(400, "Email duplicated!!"),//email重複
>>>>>>> Stashed changes
    FOOD_EXISTED(400,"Food existed!"),//
    FOOD_NOT_EXISTED(400,"Food not existed!"),//
    TOKEN_NOT_EXISTED(400,"Token not existed!"),//
    TOKEN_EXPIRED(400,"Token expired!"),//
    ;
    private int code;

    private String message;

    ResMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class ConstantsMessage{
        public static final String PARAM_EMAIL_ERROR = "Param email error!";
        public static final String PARAM_PASSWORD_ERROR = "Param password error!";
    }

}
