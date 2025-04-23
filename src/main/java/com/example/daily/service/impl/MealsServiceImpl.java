package com.example.daily.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.MealsDao;

import com.example.daily.entity.Meals;
import com.example.daily.service.ifs.MealsService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.MealsReq;

import com.example.daily.vo.SelectMealsRes;
import com.example.daily.vo.UpdateMealsReq;
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

	@Override
	public SelectMealsRes SelectMeals(MealsReq req) {
		if(mealsDao.selectCountByemail(req.getEmail()) == 0) {
			return new SelectMealsRes(ResMessage.EMAIL_NOT_EXISTED.getCode(), //
					ResMessage.EMAIL_NOT_EXISTED.getMessage());
		}
		List<Meals> list = mealsDao.selectByemail(req.getEmail());
		
		return new SelectMealsRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
		
		
	}

	@Override
	public BasicRes updateByMeals(UpdateMealsReq req) {
		mealsDao.updateByMeals(req.getMealsId(), req.getMealsName(), req.getEatTime());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}
	
	

}
