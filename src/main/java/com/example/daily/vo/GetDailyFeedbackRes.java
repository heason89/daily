package com.example.daily.vo;

import com.example.daily.entity.DailyFeedback;

import java.util.List;

public class GetDailyFeedbackRes extends BasicRes{

    private List<DailyFeedback> dailyFeedbackList;

    public List<DailyFeedback> getDailyFeedbackList() {
        return dailyFeedbackList;
    }

    public void setDailyFeedbackList(List<DailyFeedback> dailyFeedbackList) {
        this.dailyFeedbackList = dailyFeedbackList;
    }

    public GetDailyFeedbackRes() {
    }

    public GetDailyFeedbackRes(int code, String message) {
        super(code, message);
    }

    public GetDailyFeedbackRes(int code, String message, List<DailyFeedback> dailyFeedbackList) {
        super(code, message);
        this.dailyFeedbackList = dailyFeedbackList;
    }
}
