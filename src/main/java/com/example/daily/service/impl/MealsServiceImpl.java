package com.example.daily.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.MealsDao;
import com.example.daily.service.ifs.MealsService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.MealsReq;
@Service
public class MealsServiceImpl implements MealsService{
	
	@Autowired
	private MealsDao mealsDao;

	@Override
	public BasicRes fillinMeals(MealsReq req) {
		mealsDao.insertMeals(req.getEmail(), req.getMealsName(), req.getEatTime());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}
	
	

}
