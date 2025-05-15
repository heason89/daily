package com.example.daily.controller;

import com.example.daily.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.daily.service.ifs.SportsService;

import jakarta.validation.Valid;
@CrossOrigin
@RestController
@Tag(name = "Sports APIs", description = "運動選項相關 API")
public class SportsServiceController {
	
	@Autowired
	private SportsService sportsService;

	@Operation(summary = "新增運動選項", description = "新增一筆運動選項")
	@PostMapping(value ="sports/insert_sports")
	public BasicRes insertSports(@Valid @RequestBody SportsReq req) {
		return sportsService.insertSports(req);
	}

	@Operation(summary = "更新運動選項", description = "更新既有的運動選項")
	@PostMapping(value ="sports/update_sports")
	public BasicRes updateSports(@Valid @RequestBody SportsReq req) {
		return sportsService.updateSports(req);
	}

	@Operation(summary = "刪除運動選項", description = "刪除現有的運動選項")
	@PostMapping(value ="sports/delete_sports")
	public BasicRes deleteSports(@Valid @RequestBody DeleteSportsReq req) {
		return sportsService.deleteSports(req);
	}

	@Operation(summary = "查詢運動選項", description = "根據條件查詢運動選項")
	@PostMapping(value ="sports/search_sports")
	public GetSportsRes searchSports(@RequestBody SearchSportsReq req){
		return sportsService.searchSports(req);
	}

	@Operation(summary = "取得所有運動選項", description = "取得目前所有運動選項")
	@GetMapping(value ="sports/get_all_sports")
	public GetSportsRes getAllSports() {
		return sportsService.getAllSports();
	}

}
