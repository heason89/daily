package com.example.daily.service.ifs;

import org.springframework.stereotype.Service;

import com.example.daily.vo.BasicRes;
import com.example.daily.vo.ExerciseReq;

@Service
public interface ExerciseService {
	
	public BasicRes fillinExercise(ExerciseReq  req);

}
