package com.example.daily.controller;

import com.example.daily.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.MealsService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@Tag(name = "Meals APIs", description = "飲食紀錄相關 API")
public class MealsServiceController {
	
	@Autowired
	private MealsService mealsService;

	@Operation(summary = "填寫飲食紀錄", description = "新增每日飲食資料")
	@PostMapping(value ="meals/fill_in_meals")
	public BasicRes fillInMeals(@Valid @RequestBody MealsReq req) {
		return mealsService.fillInMeals(req);
	}

	@Operation(summary = "更新飲食紀錄", description = "修改既有的飲食資料")
	@PostMapping(value ="meals/update_meals")
	public BasicRes updateMeals(@Valid @RequestBody UpdateMealsReq req) {
		return mealsService.updateMeals(req);
	}

	@Operation(summary = "查詢飲食紀錄", description = "取得某使用者的飲食資料")
	@PostMapping(value ="meals/get_meals")
	public GetMealsRes getMeals(@Valid @RequestBody GetUserDataReq req) {
		return mealsService.getMeals(req);
	}

	@Operation(summary = "刪除飲食紀錄", description = "刪除特定飲食資料")
	@PostMapping(value ="meals/delete_meals")
	public BasicRes deleteMeals(@Valid @RequestBody DeleteMealsReq req) {
		return mealsService.deleteMeals(req);
	}
}