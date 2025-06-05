package com.example.daily.controller;

import com.example.daily.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.MoodService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@Tag(name = "Mood APIs", description = "心情紀錄相關 API")
public class MoodServiceController {

	@Autowired
	private MoodService moodService;

	@Operation(summary = "填寫心情紀錄", description = "填寫每日心情資料")
	@PostMapping(value = "mood/fill_in_mood")
	public BasicRes fillInMood(@Valid @RequestBody MoodReq req) {
		return moodService.fillInMood(req);
	}

	@Operation(summary = "更新心情紀錄", description = "更新既有的心情資料")
	@PostMapping(value = "mood/update_mood")
	public BasicRes updateMood(@Valid @RequestBody MoodReq req) {
		return moodService.updateMood(req);
	}

	@Operation(summary = "取得心情紀錄", description = "查詢使用者的心情資料")
	@PostMapping(value = "mood/get_mood")
	public GetMoodRes getMood(@Valid @RequestBody GetUserDataReq req) {
		return moodService.getMood(req);
	}

	@Operation(summary = "刪除心情紀錄", description = "刪除使用者的心情紀錄")
	@PostMapping(value = "mood/delete_mood")
	public BasicRes deleteMood(@Valid @RequestBody DeleteMoodReq req) {
		return moodService.deleteMood(req);
	}

	@Operation(summary = "查詢某月心情紀錄", description = "根據年月查詢該月使用者所有心情資料")
	@PostMapping(value = "mood/get_month_mood")
	public GetMoodRes getMonthMood(@Valid @RequestBody SearchMoodInMonthReq req) {
		return moodService.getMonthMood(req);
	}
	@Operation(summary = "查詢某天心情紀錄", description = "根據當天查詢該天使用者所有心情資料")
	@PostMapping(value = "mood/get_date_mood")
	public GetDateMoodRes getDateMood(@Valid @RequestBody GetDateMoodReq req) {
		return moodService.getDateMood(req);
	}
}