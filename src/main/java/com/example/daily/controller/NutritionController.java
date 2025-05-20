package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.NutritionService;
import com.example.daily.vo.NutritionRes;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {

	@Autowired
	private NutritionService nutritionService;

	@GetMapping("/search")
	public NutritionRes getNutrition(@RequestParam(name = "food") String food) {
		return nutritionService.getNutritionByFood(food);
	}

}
