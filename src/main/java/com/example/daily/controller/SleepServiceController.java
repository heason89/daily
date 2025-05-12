package com.example.daily.controller;

import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.SleepService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class SleepServiceController {
	
	@Autowired
	private SleepService sleepService;
	
	
	@PostMapping(value ="sleep/fill_in_sleep")
	public BasicRes fillInSleep(@Valid @RequestBody SleepReq req) {
		return sleepService.fillInSleep(req);
	}

	@PostMapping(value ="sleep/select_sleep")
	public GetSleepRes getSleep(@Valid @RequestBody GetUserDataReq req) {
		return sleepService.getSleep(req);
	}

	@PostMapping(value ="sleep/update_sleep")
	public BasicRes updateSleep(@Valid @RequestBody UpdateSleepReq req) {
		return sleepService.updateSleep(req);
	}

	@PostMapping(value ="sleep/delete_sleep")
	public BasicRes deleteSleep(@Valid @RequestBody DeleteSleepReq req) {
		return sleepService.deleteSleep(req);
	}
}
