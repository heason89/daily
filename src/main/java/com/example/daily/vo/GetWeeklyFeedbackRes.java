package com.example.daily.vo;

import com.example.daily.entity.WeeklyFeedback;

public class GetWeeklyFeedbackRes extends BasicRes{

    private WeeklyFeedback weeklyFeedback;

    public WeeklyFeedback getWeeklyFeedback() {
        return weeklyFeedback;
    }

    public void setWeeklyFeedback(WeeklyFeedback weeklyFeedback) {
        this.weeklyFeedback = weeklyFeedback;
    }

    public GetWeeklyFeedbackRes() {
    }

    public GetWeeklyFeedbackRes(int code, String message) {
        super(code, message);
    }

    public GetWeeklyFeedbackRes(int code, String message, WeeklyFeedback weeklyFeedbackList) {
        super(code, message);
        this.weeklyFeedback = weeklyFeedbackList;
    }
}
