package com.example.daily.vo;

import com.example.daily.entity.DailyFeedback;

public class GetDailyFeedbackRes extends BasicRes{

    private DailyFeedback dailyFeedback;

    public DailyFeedback getDailyFeedback() {
        return dailyFeedback;
    }

    public void setDailyFeedback(DailyFeedback dailyFeedback) {
        this.dailyFeedback = dailyFeedback;
    }

    public GetDailyFeedbackRes() {
    }

    public GetDailyFeedbackRes(int code, String message) {
        super(code, message);
    }

    public GetDailyFeedbackRes(int code, String message, DailyFeedback dailyFeedbackList) {
        super(code, message);
        this.dailyFeedback = dailyFeedbackList;
    }
}
