package com.example.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.daily.service.ifs.SportsService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.SportsReq;

import jakarta.validation.Valid;
@CrossOrigin
@RestController
public class SportsServiceController {
	
	@Autowired
	private SportsService sportsService;
	
	@PostMapping(value ="sports/fillinSports")
	public BasicRes fillinSports(@Valid @RequestBody SportsReq req) {
		return sportsService.fillinSports(req);
}

}
