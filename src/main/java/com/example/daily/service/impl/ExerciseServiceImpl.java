package com.example.daily.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import com.example.daily.dao.SportsDao;
import com.example.daily.entity.Sports;
import com.example.daily.util.JwtUtil;
import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.ExerciseDao;
import com.example.daily.entity.Exercise;
import com.example.daily.service.ifs.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	@Autowired
	private ExerciseDao exerciseDao;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private SportsDao sportsDao;

	@Override
	public BasicRes fillInExercise(ExerciseReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new BasicRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 檢查 req 的 date 和 duration
		BasicRes date = checkReq(req);
		if(date.getCode()==400){
			return date;
		}
		// 取得該運動消耗的卡路里並計算總消耗
		Sports sports = sportsDao.getBySportsName(req.getExerciseName());
		int totalConsumed = sports.getConsume()*req.getDuration();
		exerciseDao.insertExercise(userId, req.getDate(),//
				req.getDuration(), req.getExerciseName(),totalConsumed);
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes updateExercise(UpdateExerciseReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new BasicRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 取得 exerciseId 該筆運動資料
		Exercise exercise = exerciseDao.getByExerciseId(req.getExerciseId(),userId);
		if(exercise==null){
			return new BasicRes(ResMessage.ID_MISMATCH.getCode(), //
					ResMessage.ID_MISMATCH.getMessage());
		}
		// 檢查 req 的 date 和 duration
		BasicRes date = checkReq(req);
		if(date.getCode()==400){
			return date;
		}
		// 取得該運動消耗的卡路里並計算總消耗
		Sports sports = sportsDao.getBySportsName(req.getExerciseName());
		int totalConsumed = sports.getConsume()*req.getDuration();
		exerciseDao.updateByExercise(req.getExerciseId(),req.getDate(),//
				req.getDuration(),req.getExerciseName(),totalConsumed);
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes deleteExercise(DeleteExerciseReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new BasicRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 取得 exerciseId 該筆運動資料
		Exercise exercise = exerciseDao.getByExerciseId(req.getExerciseId(),userId);
		if(exercise==null){
			return new BasicRes(ResMessage.ID_MISMATCH.getCode(), //
					ResMessage.ID_MISMATCH.getMessage());
		}
		exerciseDao.deleteExercise(req.getExerciseId());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public GetExerciseRes getExercise(GetUserDataReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new GetExerciseRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Exercise> list = exerciseDao.getByUserId(userId);
		return new GetExerciseRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

	@Override
	public GetExerciseRes getCalendarExercise(GetUserDataReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new GetExerciseRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 抓當周星期一日期
		LocalDate monday = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		List<Exercise> list = exerciseDao.getByMonday(userId,monday);
		return new GetExerciseRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}	
	//取得當天
	@Override
	public GetExerciseRes getDateExercise(GetDateExerciseReq req) {
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new GetExerciseRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Exercise> list = exerciseDao.getByDate(userId,req.getDate());
		return new GetExerciseRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
		
	}
	private BasicRes checkReq(ExerciseReq  req){
		// 檢查 duration 是否大於0
		if (req.getDuration() <=0){
			return new BasicRes(ResMessage.PARAM_DURATION_ERROR.getCode(), //
					ResMessage.PARAM_DURATION_ERROR.getMessage());
		}
		// 檢查 date 距離今天是否超過7天
		if (req.getDate().isBefore(LocalDate.now().minusDays(7))){
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(),//
					ResMessage.DATE_EXPIRED.getMessage());
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(),//
				ResMessage.SUCCESS.getMessage());
	}
	
}
