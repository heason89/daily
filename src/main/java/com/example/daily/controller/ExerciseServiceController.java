package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.ExerciseService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.ExerciseReq;
import com.example.daily.vo.UpdateExerciseReq;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class ExerciseServiceController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@PostMapping(value ="exercise/fill_in_exercise")
	public BasicRes fillInExercise(@Valid @RequestBody ExerciseReq req) {
		return exerciseService.fillInExercise(req);
	}
	@PostMapping(value ="exercise/update_exercise")
	public BasicRes updateExercise(@Valid @RequestBody UpdateExerciseReq req) {
		return exerciseService.updateExercise(req);
	}

	@PostMapping(value ="exercise/selectexercise")
	public BasicRes selectExercise(@Valid @RequestBody ExerciseReq req) {
		return exerciseService.getByEmail(req);
	}
}
}