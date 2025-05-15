package com.example.daily.controller;

import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.MoodService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class MoodServiceController {

	@Autowired
	private MoodService moodService;

	@PostMapping(value = "mood/fill_in_mood")
	public BasicRes fillInMood(@Valid @RequestBody MoodReq req) {
		return moodService.fillInMood(req);
	}

	@PostMapping(value = "mood/update_mood")
	public BasicRes updateMood(@Valid @RequestBody MoodReq req) {
		return moodService.updateMood(req);
	}

	@PostMapping(value = "mood/get_mood")
	public GetMoodRes getMood(@Valid @RequestBody GetUserDataReq req) {
		return moodService.getMood(req);
	}

	@PostMapping(value = "mood/delete_mood")
	public BasicRes deleteMood(@Valid @RequestBody DeleteMoodReq req) {
		return moodService.deleteMood(req);
	}

	@PostMapping(value = "mood/get_month_mood")
	public GetMoodRes getMonthMood(@Valid @RequestBody SearcMoodInMonthReq req) {
		return moodService.getMonthMood(req);
	}
}