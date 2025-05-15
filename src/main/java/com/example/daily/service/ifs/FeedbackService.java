package com.example.daily.service.ifs;

import com.example.daily.vo.*;

public interface FeedbackService {

    public BasicRes fillInDailyFeedback(FeedbackReq req);

    public BasicRes fillInWeeklyFeedback(FeedbackReq req);

    public GetDailyFeedbackRes getDailyFeedback(GetByDateReq req);

    public GetAllDailyFeedbackRes getAllDailyFeedback(GetUserDataReq req);

    public GetWeeklyFeedbackRes getWeeklyFeedback(GetByDateReq req);

    public GetAllWeeklyFeedbackRes getAllWeeklyFeedback(GetUserDataReq req);
}
