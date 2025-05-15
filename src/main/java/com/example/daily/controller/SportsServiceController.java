package com.example.daily.controller;

import com.example.daily.vo.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.daily.service.ifs.SportsService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class SportsServiceController {
	
	@Autowired
	private SportsService sportsService;
	
	@PostMapping(value ="sports/insert_sports")
	public BasicRes insertSports(@Valid @RequestBody SportsReq req) {
		return sportsService.insertSports(req);
	}

	@PostMapping(value ="sports/update_sports")
	public BasicRes updateSports(@Valid @RequestBody SportsReq req) {
		return sportsService.updateSports(req);
	}

	@PostMapping(value ="sports/delete_sports")
	public BasicRes deleteSports(@Valid @RequestBody DeleteSportsReq req) {
		return sportsService.deleteSports(req);
	}

	@PostMapping(value ="sports/search_sports")
	public GetSportsRes searchSports(@RequestBody SearchSportsReq req){
		return sportsService.searchSports(req);
	}

	@GetMapping(value ="sports/get_all_sports")
	public GetSportsRes getAllSports() {
		return sportsService.getAllSports();
	}

}
