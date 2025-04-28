package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.SleepService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.SelectSleepRes;
import com.example.daily.vo.SleepReq;
import com.example.daily.vo.UpdateSleepReq;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class SleepServiceController {
	
	@Autowired
	private SleepService sleepService;
	
	
	@PostMapping(value ="sleep/fillin_sleep")
	public BasicRes fillinSleep(@Valid @RequestBody SleepReq req) {
		return sleepService.fillinSleep(req);
		
	}
	@PostMapping(value ="sleep/select_sleep")
	public SelectSleepRes selectSleep(@Valid @RequestBody SleepReq req) {
		return sleepService.selectSleep(req);
		
	}
	@PostMapping(value ="sleep/update_sleep")
	public BasicRes updateSleep(@Valid @RequestBody UpdateSleepReq req) {
		return sleepService.updateSleep(req);
		
	}
}
