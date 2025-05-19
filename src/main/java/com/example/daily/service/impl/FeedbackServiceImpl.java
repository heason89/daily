package com.example.daily.service.impl;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.*;
import com.example.daily.entity.*;
import com.example.daily.service.ifs.FeedbackService;
import com.example.daily.util.JwtUtil;
import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private DailyFeedbackDao dailyFeedbackDao;

    @Autowired
    private WeeklyFeedbackDao weeklyFeedbackDao;

    @Autowired
    private MealsDao mealsDao;

    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private SleepDao sleepDao;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public GetDataRes getDataByDate(GetByDateReq req) {
        // 驗證 token 是否有效 及 解析出 userId
        ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
        if(res.getCode()!=200)
        {
            return new GetDataRes(res.getCode(),res.getMessage());
        }
        // 取得 userId
        int userId = res.getUserId();
        LocalDate date =req.getDate();
        List<Exercise> exerciseList = exerciseDao.getByDate(userId,date);
        List<Meals> mealsList = mealsDao.GetDateMeals(userId,date);
        List<Sleep> sleepList = sleepDao.GetSleepByDate(userId,date);
        return new GetDataRes(ResMessage.SUCCESS.getCode(), //
                ResMessage.SUCCESS.getMessage(),exerciseList,mealsList,sleepList);
    }

    @Override
    public BasicRes fillInDailyFeedback(FeedbackReq req) {
        // 驗證 token 是否有效 及 解析出 userId
        ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
        if(res.getCode()!=200)
        {
            return new BasicRes(res.getCode(),res.getMessage());
        }
        // 取得 userId
        int userId = res.getUserId();
        DailyFeedback daily = dailyFeedbackDao.getDailyByDate(userId,req.getDate());
        if(daily!=null){
            return new BasicRes(ResMessage.FEEDBACK_EXISTED.getCode(), //
                    ResMessage.FEEDBACK_EXISTED.getMessage());
        }
        // 新增 dailyFeedback
        dailyFeedbackDao.insertDaily(userId,req.getDate(),req.getFeedback());
        return new BasicRes(ResMessage.SUCCESS.getCode(), //
                ResMessage.SUCCESS.getMessage());
    }

    @Override
    public BasicRes fillInWeeklyFeedback(FeedbackReq req) {
        // 驗證 token 是否有效 及 解析出 userId
        ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
        if(res.getCode()!=200)
        {
            return new BasicRes(res.getCode(),res.getMessage());
        }
        // 取得 userId
        int userId = res.getUserId();
        WeeklyFeedback weekly = weeklyFeedbackDao.getWeeklyByDate(userId,req.getDate());
        if(weekly!=null){
            return new BasicRes(ResMessage.FEEDBACK_EXISTED.getCode(), //
                    ResMessage.FEEDBACK_EXISTED.getMessage());
        }
        // 新增 weeklyFeedback
        weeklyFeedbackDao.insertWeekly(userId,req.getDate(),req.getFeedback());
        return new BasicRes(ResMessage.SUCCESS.getCode(), //
                ResMessage.SUCCESS.getMessage());
    }
    @Override
    public GetDailyFeedbackRes getDailyFeedback(GetByDateReq req) {
        // 驗證 token 是否有效 及 解析出 userId
        ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
        if (res.getCode() != 200) {
            return new GetDailyFeedbackRes(res.getCode(), res.getMessage());
        }
        // 取得 userId
        int userId = res.getUserId();
        // 取得 dailyFeedback
        DailyFeedback feedback = dailyFeedbackDao.getDailyByDate(userId,req.getDate());
        return new GetDailyFeedbackRes(ResMessage.SUCCESS.getCode(), //
                ResMessage.SUCCESS.getMessage(),feedback);
    }

    @Override
    public GetAllDailyFeedbackRes getAllDailyFeedback(GetUserDataReq req) {
        // 驗證 token 是否有效 及 解析出 userId
        ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
        if (res.getCode() != 200) {
            return new GetAllDailyFeedbackRes(res.getCode(), res.getMessage());
        }
        // 取得 userId
        int userId = res.getUserId();
        // 取得 dailyFeedback
        List<DailyFeedback> feedback= dailyFeedbackDao.getDailyByUserId(userId);
        return new GetAllDailyFeedbackRes(ResMessage.SUCCESS.getCode(), //
                ResMessage.SUCCESS.getMessage(),feedback);
    }

    @Override
    public GetWeeklyFeedbackRes getWeeklyFeedback(GetByDateReq req) {
        // 驗證 token 是否有效 及 解析出 userId
        ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
        if(res.getCode()!=200)
        {
            return new GetWeeklyFeedbackRes(res.getCode(),res.getMessage());
        }
        // 取得 userId
        int userId = res.getUserId();
        // 取得 weeklyFeedback
        WeeklyFeedback feedback = weeklyFeedbackDao.getWeeklyByDate(userId,req.getDate());
        return new GetWeeklyFeedbackRes(ResMessage.SUCCESS.getCode(), //
                ResMessage.SUCCESS.getMessage(),feedback);
    }

    @Override
    public GetAllWeeklyFeedbackRes getAllWeeklyFeedback(GetUserDataReq req) {
        // 驗證 token 是否有效 及 解析出 userId
        ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
        if(res.getCode()!=200)
        {
            return new GetAllWeeklyFeedbackRes(res.getCode(),res.getMessage());
        }
        // 取得 userId
        int userId = res.getUserId();
        // 取得 weeklyFeedback
        List<WeeklyFeedback> feedback = weeklyFeedbackDao.getWeeklyByUserId(userId);
        return new GetAllWeeklyFeedbackRes(ResMessage.SUCCESS.getCode(), //
                ResMessage.SUCCESS.getMessage(),feedback);
    }
}
