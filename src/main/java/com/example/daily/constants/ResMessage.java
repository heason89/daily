package com.example.daily.constants;

public enum ResMessage {

    SUCCESS(200,"Success!"),//
    EMAIL_NOT_EXISTED(400,"Email not existed!"),//
    EMAIL_EXISTED(400,"Email existed!"),//
    PASSWORD_MISMATCH(400,"Password mismatch!"),//
    PARAM_DATE_TIME_ERROR(400,"param date time error"),// 開始時間 > 結束時間
    EMAIL_DUPLICATED(400, "Email duplicated!!"),//email重複
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

        public static final String PARAM_SLEEP_Time_ERROR = "Param sleep_time error!";
        public static final String PARAM_AWAKE_Time_ERROR = "Param awake_time error!";
        public static final String PARAM_MEALS_NAME_ERROR = "Param meals_name error!";
        public static final String PARAM_EAT_Time_ERROR = "Param eat_time error!";
        public static final String PARAM_DATE_ERROR = "Param date error!"; //運動開始時間
        public static final String PARAM_DURATION_ERROR = "Param duration error!";
        public static final String PARAM_EXERCISENAME_ERROR = "Param exerciseName error!";
        public static final String PARAM_SPORTS_TYPE_ERROR = "Param sports_type error!";
        public static final String PARAM_CONSUME_ERROR = "Param consume error!";

    }

}
