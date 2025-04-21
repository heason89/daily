package com.example.daily.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.ExerciseDao;
import com.example.daily.service.ifs.ExerciseService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.ExerciseReq;
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

}
