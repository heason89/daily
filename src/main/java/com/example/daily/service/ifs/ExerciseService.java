package com.example.daily.service.ifs;

import org.springframework.stereotype.Service;

import com.example.daily.vo.BasicRes;
import com.example.daily.vo.ExerciseReq;
import com.example.daily.vo.SelectExerciseRes;
import com.example.daily.vo.UpdateExerciseReq;


@Service
public interface ExerciseService {
	
	public BasicRes fillinExercise(ExerciseReq  req);
	
	public BasicRes updateByExercise(UpdateExerciseReq  req);
	
	public SelectExerciseRes selectByemail(ExerciseReq  req);
	
	public SelectExerciseRes select();

}
