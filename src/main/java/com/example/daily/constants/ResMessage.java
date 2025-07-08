package com.example.daily.constants;

public enum ResMessage {

	SUCCESS(200, "Success!"), //
	EMAIL_NOT_EXISTED(400, "Email not existed!"), //
	USER_ID_NOT_EXISTED(400, "User id not existed!"), //
	EMAIL_EXISTED(400, "Email existed!"), //
	EMAIL_HAS_BEEN_CANCELED(400, "Email has been canceled!"), //
	PASSWORD_MISMATCH(400, "Password mismatch!"), //
	PARAM_DATE_TIME_ERROR(400, "Param date time error"), // 開始時間 > 結束時間
	FOOD_EXISTED(400, "Food existed!"), //
	FOOD_NOT_EXISTED(400, "Food not existed!"), //
	SPORTS_EXISTED(400, "Sports existed!"), //
	SPORTS_NOT_EXISTED(400, "Sports not existed!"), //
	TOKEN_EXPIRED(400, "Token expired!"),//
	DATE_EXPIRED(400, "Date expired!"),//
	PARAM_DURATION_ERROR(400, "Param duration error!"),//
	PARAM_FREQENCY_ERROR(400, "Param frequency error!"),//
	ID_MISMATCH(400, "Id mismatch!"),//
	FEEDBACK_EXISTED(400, "Feedback existed!"),//
	INVALID_TOKEN(400, "Invalid token!"),//
	TOKEN_ERROR(400, "Token error!"),//
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

	public static class ConstantsMessage {
		public static final String PARAM_EMAIL_ERROR = "Param email error!";
		public static final String EMAIL_FORMAT_ERROR = "Email format error!";
		public static final String PARAM_PASSWORD_ERROR = "Param password error!";
		public static final String PARAM_SLEEP_ID_ERROR = "Param sleep_id error!";
		public static final String PARAM_MEALS_NAME_ERROR = "Param meals_name error!";
		public static final String PARAM_MEALS_ID_ERROR = "Param meals_id error!";
		public static final String PARAM_EAT_TIME_ERROR = "Param eat_time error!";
		public static final String PARAM_EAT_DATE_ERROR = "Param eat_date error!";
		public static final String PARAM_DATE_ERROR = "Param date error!"; // 運動開始時間
		public static final String PARAM_DURATION_ERROR = "Param duration error!";
		public static final String PARAM_FREQUENCY_ERROR = "Param frequency error!";
		public static final String PARAM_EXERCISE_NAME_ERROR = "Param exercise_name error!";
		public static final String PARAM_EXERCISE_ID_ERROR = "Param exercise_id error!";
		public static final String PARAM_SPORTS_NAME_ERROR = "Param sports_name error!";
		public static final String PARAM_SPORTS_TYPE_ERROR = "Param sports_type error!";
		public static final String PARAM_CONSUME_ERROR = "Param consume error!";
		public static final String PARAM_MOOD_ERROR = "Param mood error!";
		public static final String PARAM_FOOD_NAME_ERROR = "Param food_name error!";
		public static final String PARAM_COOKING_METHOD_ERROR = "Param cooking_method error!";
		public static final String PARAM_FOOD_PHOTO_ERROR = "Param food photo error!";
		public static final String PARAM_TYPE_ERROR = "Param type error!";
		public static final String PARAM_TOKEN_ERROR = "Param token error!";
		public static final String PARAM_USER_ID_ERROR = "Param user_id error!";
		public static final String PARAM_HOURS_ERROR = "Param hours error!";
		public static final String PARAM_MEALS_TYPE_ERROR = "Param meals type error!";
		public static final String PARAM_WEIGHT_ERROR = "Param weight error!";
	}
}
