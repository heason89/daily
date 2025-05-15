package com.example.daily.vo;

import com.example.daily.entity.DailyFeedback;

import java.util.List;

public class GetAllDailyFeedbackRes extends BasicRes{

    private List<DailyFeedback> dailyFeedbackList;

    public List<DailyFeedback> getDailyFeedbackList() {
        return dailyFeedbackList;
    }

    public void setDailyFeedbackList(List<DailyFeedback> dailyFeedbackList) {
        this.dailyFeedbackList = dailyFeedbackList;
    }

    public GetAllDailyFeedbackRes() {
    }

    public GetAllDailyFeedbackRes(int code, String message) {
        super(code, message);
    }

    public GetAllDailyFeedbackRes(int code, String message, List<DailyFeedback> dailyFeedbackList) {
        super(code, message);
        this.dailyFeedbackList = dailyFeedbackList;
    }
}
