package com.example.daily.controller;

import com.example.daily.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.SleepService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@Tag(name = "Sleep APIs", description = "睡眠紀錄相關 API")
public class SleepServiceController {
	
	@Autowired
	private SleepService sleepService;

	@Operation(summary = "填寫睡眠紀錄", description = "填寫每日睡眠資訊")
	@PostMapping(value ="sleep/fill_in_sleep")
	public BasicRes fillInSleep(@Valid @RequestBody SleepReq req) {
		return sleepService.fillInSleep(req);
	}

	@Operation(summary = "取得睡眠紀錄", description = "取得使用者睡眠資料")
	@PostMapping(value ="sleep/get_sleep")
	public GetSleepAllRes getSleep(@Valid @RequestBody GetUserDataReq req) {
		return sleepService.getSleep(req);
	}
	@Operation(summary = "取得當天睡眠紀錄", description = "取得使用者當天睡眠資料")
	@PostMapping(value ="sleep/get_date_sleep")
	public GetSleepRes getDateSleep(@Valid @RequestBody GetDateSleepReq req) {
		return sleepService.getDateSleep(req);
	}

	@Operation(summary = "更新睡眠紀錄", description = "更新使用者既有的睡眠資料")
	@PostMapping(value ="sleep/update_sleep")
	public BasicRes updateSleep(@Valid @RequestBody UpdateSleepReq req) {
		return sleepService.updateSleep(req);
	}

	@Operation(summary = "刪除睡眠紀錄", description = "刪除使用者的睡眠資料")
	@PostMapping(value ="sleep/delete_sleep")
	public BasicRes deleteSleep(@Valid @RequestBody DeleteSleepReq req) {
		return sleepService.deleteSleep(req);
	}
}
