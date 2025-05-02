package com.example.daily.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import com.example.daily.dao.UserDao;
import com.example.daily.entity.User;
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
	private UserDao userDao;

	@Override
	public BasicRes fillInExercise(ExerciseReq req) {
		// 檢查 email 是否已存在
		User userEmail =userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if(res.getCode()==400){
			return res;
		}
		// 檢查 req 的 date 和 duration
		res =checkReq(req);
		if(res.getCode()==400){
			return res;
		}
		exerciseDao.insertExercise(req.getEmail(), req.getDate(), req.getDuration(), req.getExerciseName());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes updateExercise(UpdateExerciseReq req) {
		// 檢查 email 是否已存在
		User userEmail =userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if(res.getCode()==400){
			return res;
		}
		Exercise exercise = exerciseDao.getByExerciseId(req.getExerciseId());
		res =checkExercise(exercise,userEmail);
		if(res.getCode()==400){
			return res;
		}
		// 檢查 req 的 date 和 duration
		res =checkReq(req);
		if(res.getCode()==400){
			return res;
		}
		exerciseDao.updateByExercise(req.getExerciseId(),req.getDate(),//
				req.getDuration(),req.getExerciseName());
		
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes deleteExercise(DeleteExerciseReq req) {
		// 檢查 email 是否已存在
		User userEmail =userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if(res.getCode()==400){
			return res;
		}
		Exercise exercise = exerciseDao.getByExerciseId(req.getExerciseId());
		// 呼叫 checkExercise 檢查
		res =checkExercise(exercise,userEmail);
		if(res.getCode()==400){
			return res;
		}
		exerciseDao.deleteExercise(req.getExerciseId());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public GetExerciseRes getByEmail(GetExerciseReq req) {
		// 檢查 email 是否已存在
		User userEmail =userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if(res.getCode()==400){
			return new GetExerciseRes(res.getCode(),res.getMessage());
		}
		List<Exercise> list = exerciseDao.getByEmail(req.getEmail());
		return new GetExerciseRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

	@Override
	public GetExerciseRes getCalendarExercise(GetExerciseReq req) {
		// 檢查 email 是否已存在
		User userEmail =userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if(res.getCode()==400){
			return new GetExerciseRes(res.getCode(),res.getMessage());
		}
		// 抓當周星期一日期
		LocalDate monday = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		List<Exercise> list = exerciseDao.getByMonday(req.getEmail(),monday);
		return new GetExerciseRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

	private BasicRes checkmail(User usermail){
		// 帳號不存在
		if (usermail == null){
			return new BasicRes(ResMessage.EMAIL_NOT_EXISTED.getCode(),//
					ResMessage.EMAIL_NOT_EXISTED.getMessage());
		}
		// 帳號已註銷
		if (!usermail.isActive()){
			return new BasicRes(ResMessage.EMAIL_HAS_BEEN_CANCELED.getCode(),//
					ResMessage.EMAIL_HAS_BEEN_CANCELED.getMessage());
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(),//
				ResMessage.SUCCESS.getMessage());
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

	private BasicRes checkExercise(Exercise exercise,User userEmail){
		// 檢查 exercise 是否存在
		if (exercise==null){
			return new BasicRes(ResMessage.EXERCISE_NOT_EXISTED.getCode(), //
					ResMessage.EXERCISE_NOT_EXISTED.getMessage());
		}
		// 檢查該 exerciseId 是不是該 email 填寫的
		if(!userEmail.getEmail().equals(exercise.getEmail())){
			return new BasicRes(ResMessage.MAIL_MISMATCH.getCode(), //
					ResMessage.MAIL_MISMATCH.getMessage());
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(),//
				ResMessage.SUCCESS.getMessage());
	}
	
}
