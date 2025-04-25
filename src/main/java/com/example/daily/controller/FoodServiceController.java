package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.FoodService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.FoodReq;
import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class FoodServiceController {

	@Autowired
	private FoodService foodService;

	@PostMapping(value ="food/foodInsert")
	public BasicRes foodInsert(@Valid @RequestBody FoodReq req) {
		return foodService.foodInsert(req);
}
	@PostMapping(value ="food/foodUpdate")
	public BasicRes UpdateExercise(@Valid @RequestBody FoodReq req) {
		return foodService.foodUpdate(req);
	}
	@PostMapping(value ="food/deleteFood")
	public BasicRes deleteFood(@Valid @RequestBody FoodReq req) {
		return foodService.deleteFood(req);
	}
	@PostMapping(value ="food/selectFood")
	public GetFoodRes selectFood(@Valid @RequestBody FoodReq req) {
		return foodService.selectFood(req);
	}
}