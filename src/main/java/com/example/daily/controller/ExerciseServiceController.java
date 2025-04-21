package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.ExerciseService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.ExerciseReq;


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
	

}
