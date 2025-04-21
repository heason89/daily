package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.MoodService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.MoodReq;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class MoodServiceController {
	
	@Autowired
	private MoodService moodService;
	
	@PostMapping(value ="mood/fillinMood")
	public BasicRes fillinMood(@Valid @RequestBody MoodReq req) {
		return moodService.fillinMood(req);

}
}