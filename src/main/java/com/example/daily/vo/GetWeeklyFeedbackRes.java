package com.example.daily.vo;

import com.example.daily.entity.DailyFeedback;
import com.example.daily.entity.WeeklyFeedback;

import java.util.List;

public class GetWeeklyFeedbackRes extends BasicRes{

    private WeeklyFeedback weeklyFeedbackList;

    public WeeklyFeedback getWeeklyFeedbackList() {
        return weeklyFeedbackList;
    }

    public void setWeeklyFeedbackList(WeeklyFeedback weeklyFeedbackList) {
        this.weeklyFeedbackList = weeklyFeedbackList;
    }

    public GetWeeklyFeedbackRes() {
    }

    public GetWeeklyFeedbackRes(int code, String message) {
        super(code, message);
    }

    public GetWeeklyFeedbackRes(int code, String message, WeeklyFeedback weeklyFeedbackList) {
        super(code, message);
        this.weeklyFeedbackList = weeklyFeedbackList;
    }
}
