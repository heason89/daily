package com.example.daily.controller;

import com.example.daily.service.ifs.FeedbackService;
import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping(value ="feedback/fill_in_daily")
    public BasicRes fillInDailyFeedback(FeedbackReq req){
        return feedbackService.fillInDailyFeedback(req);
    }

    @PostMapping(value ="feedback/fill_in_weekly")
    public BasicRes fillInWeeklyFeedback(FeedbackReq req){
        return feedbackService.fillInWeeklyFeedback(req);
    }

    @PostMapping(value ="feedback/get_daily")
    public GetDailyFeedbackRes getDailyFeedback(GetUserDataReq req){
        return feedbackService.getDailyFeedback(req);
    }

    @PostMapping(value ="feedback/get_weekly")
    public GetWeeklyFeedbackRes getWeeklyFeedback(GetUserDataReq req){
        return feedbackService.getWeeklyFeedback(req);
    }
}
