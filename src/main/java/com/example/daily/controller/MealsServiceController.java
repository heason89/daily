package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.MealsService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.MealsReq;
import com.example.daily.vo.SelectMealsRes;
import com.example.daily.vo.UpdateMealsReq;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class MealsServiceController {
	
	@Autowired
	private MealsService mealsService;
	
	@PostMapping(value ="meals/fillinMeals")
	public BasicRes fillinMeals(@Valid @RequestBody MealsReq req) {
		return mealsService.fillinMeals(req);
}
	@PostMapping(value ="meals/updateMeals")
	public BasicRes UpdateMeals(@Valid @RequestBody UpdateMealsReq req) {
		return mealsService.updateByMeals(req);
}
	@PostMapping(value ="meals/selectMeals")
	public SelectMealsRes selectMeals(@Valid @RequestBody MealsReq req) {
		return mealsService.SelectMeals(req);
}
}