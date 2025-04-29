package com.example.daily.controller;

import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.daily.service.ifs.FoodService;
import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class FoodServiceController {

	@Autowired
	private FoodService foodService;

	@PostMapping(value ="food/insert_food")
	public BasicRes insertFood(@Valid @RequestBody FoodReq req) {
		return foodService.insertFood(req);
}
	@PostMapping(value ="food/update_food")
	public BasicRes updateFood(@Valid @RequestBody FoodReq req) {
		return foodService.updateFood(req);
	}
	@PostMapping(value ="food/delete_food")
	public BasicRes deleteFood(@Valid @RequestBody DeleteFoodReq req) {
		return foodService.deleteFood(req);
	}
	@PostMapping(value ="food/search_food")
	public GetFoodRes searchFood(@RequestBody SearchFoodReq req) {
		return foodService.searchFood(req);
	}
	@GetMapping(value ="food/get_all_food")
	public GetFoodRes getAllFood() {
		return foodService.getAllFood();
	}
}