package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping(value ="exercise/fillinExercise")
	public BasicRes fillinExercise(@Valid @RequestBody ExerciseReq req) {
		return exerciseService.fillinExercise(req);
		
	}
	@PostMapping(value ="exercise/UpdateExercise")
	public BasicRes UpdateExercise(@Valid @RequestBody UpdateExerciseReq req) {
		return exerciseService.updateByExercise(req);
	}
		
	@PostMapping(value ="exercise/selectExercise")
	public BasicRes selectExercise(@Valid @RequestBody ExerciseReq req) {
		return exerciseService.selectByemail(req);
	}
	@GetMapping(value ="exercise/select")
	public BasicRes select() {
		return exerciseService.select();
	}
}