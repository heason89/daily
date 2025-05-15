package com.example.daily.vo;

import com.example.daily.entity.DailyFeedback;

import java.util.List;

public class GetDailyFeedbackRes extends BasicRes{

    private DailyFeedback dailyFeedbackList;

    public DailyFeedback getDailyFeedbackList() {
        return dailyFeedbackList;
    }

    public void setDailyFeedbackList(DailyFeedback dailyFeedbackList) {
        this.dailyFeedbackList = dailyFeedbackList;
    }

    public GetDailyFeedbackRes() {
    }

    public GetDailyFeedbackRes(int code, String message) {
        super(code, message);
    }

    public GetDailyFeedbackRes(int code, String message, DailyFeedback dailyFeedbackList) {
        super(code, message);
        this.dailyFeedbackList = dailyFeedbackList;
    }
}
