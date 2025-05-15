package com.example.daily.vo;

import com.example.daily.entity.WeeklyFeedback;

import java.util.List;

public class GetAllWeeklyFeedbackRes extends BasicRes{

    private List<WeeklyFeedback> weeklyFeedbackList;

    public List<WeeklyFeedback> getWeeklyFeedbackList() {
        return weeklyFeedbackList;
    }

    public void setWeeklyFeedbackList(List<WeeklyFeedback> weeklyFeedbackList) {
        this.weeklyFeedbackList = weeklyFeedbackList;
    }

    public GetAllWeeklyFeedbackRes() {
    }

    public GetAllWeeklyFeedbackRes(int code, String message) {
        super(code, message);
    }

    public GetAllWeeklyFeedbackRes(int code, String message, List<WeeklyFeedback> weeklyFeedbackList) {
        super(code, message);
        this.weeklyFeedbackList = weeklyFeedbackList;
    }
}
