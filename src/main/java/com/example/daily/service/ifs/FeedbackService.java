package com.example.daily.service.ifs;

import com.example.daily.vo.*;
import org.springframework.stereotype.Service;

@Service
public interface FeedbackService {

    public BasicRes fillInDailyFeedback(FeedbackReq req);

    public BasicRes fillInWeeklyFeedback(FeedbackReq req);

    public GetDailyFeedbackRes getDailyFeedback(GetUserDataReq req);

    public GetWeeklyFeedbackRes getWeeklyFeedback(GetUserDataReq req);
}
