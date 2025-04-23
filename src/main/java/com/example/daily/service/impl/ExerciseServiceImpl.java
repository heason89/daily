package com.example.daily.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.ExerciseDao;
import com.example.daily.entity.Exercise;
import com.example.daily.service.ifs.ExerciseService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.ExerciseReq;
import com.example.daily.vo.SelectExerciseRes;
import com.example.daily.vo.UpdateExerciseReq;

@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	@Autowired
	private ExerciseDao exerciseDao;

	@Override
	public BasicRes fillinExercise(ExerciseReq req) {
		exerciseDao.insertExercise(req.getEmail(), req.getDate(), req.getDuration(), req.getExerciseName());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes updateByExercise(UpdateExerciseReq req) {
		
		exerciseDao.updateByExercise(req.getExerciseId(),req.getDate(),//
				req.getDuration(),req.getExerciseName());
		
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public SelectExerciseRes selectByemail(ExerciseReq  req) {
		if(exerciseDao.selectCountByemail(req.getEmail()) == 0) {
			return new SelectExerciseRes(ResMessage.EMAIL_NOT_EXISTED.getCode(), //
					ResMessage.EMAIL_NOT_EXISTED.getMessage());
		}
		List<Exercise> list = exerciseDao.selectByemail(req.getEmail());
		
		return new SelectExerciseRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
		
	}

	@Override
	public SelectExerciseRes select() {
		List<Exercise> list = exerciseDao.select();
		return new SelectExerciseRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}
	
}
