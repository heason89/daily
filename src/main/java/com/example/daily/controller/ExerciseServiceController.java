package com.example.daily.controller;

import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.ExerciseService;

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

	@PostMapping(value ="exercise/delete_exercise")
	public BasicRes deleteExercise(@Valid @RequestBody DeleteExerciseReq req) {
		return exerciseService.deleteExercise(req);
	}

	@PostMapping(value ="exercise/get_exercise")
	public GetExerciseRes getExercise(@Valid @RequestBody GetUserDataReq req) {
		return exerciseService.getExercise(req);
	}

	@PostMapping(value ="exercise/get_calendar_exercise")
	public GetExerciseRes getCalendarExercise(@Valid @RequestBody GetUserDataReq req) {
		return exerciseService.getCalendarExercise(req);
	}
}
