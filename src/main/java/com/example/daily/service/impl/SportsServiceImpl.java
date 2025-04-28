package com.example.daily.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.SportsDao;
import com.example.daily.service.ifs.SportsService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.SportsReq;

@Service
public class SportsServiceImpl implements SportsService{
	
	@Autowired
	private SportsDao sportsDao;

	@Override
	public BasicRes fillinSports(SportsReq req) {
		sportsDao.insertSports(req.getSportsName(), req.getSportsType(), req.getConsume());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

}
