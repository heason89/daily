package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.SleepService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.SleepReq;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class SleepServiceController {
	
	@Autowired
	private SleepService sleepService;
	
	
	@PostMapping(value ="sleep/fillinSleep")
	public BasicRes fillinSleep(@Valid @RequestBody SleepReq req) {
		return sleepService.fillinSleep(req);
		
	}

}
