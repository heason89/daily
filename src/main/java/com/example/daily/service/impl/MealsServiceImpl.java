package com.example.daily.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.MealsDao;

import com.example.daily.entity.Meals;
import com.example.daily.entity.Mood;
import com.example.daily.service.ifs.MealsService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.DeleteMealsReq;
import com.example.daily.vo.MealsReq;

import com.example.daily.vo.SelectMealsRes;
import com.example.daily.vo.UpdateMealsReq;

@Service
public class MealsServiceImpl implements MealsService {

	@Autowired
	private MealsDao mealsDao;

	// 填寫
	@Override
	public BasicRes fillinMeals(MealsReq req) {
		// 檢查Email有沒有重複
		if (mealsDao.selectCountByEmail(req.getEmail()) == 1) {
			return new BasicRes(ResMessage.EMAIL_EXISTED.getCode(), //
					ResMessage.EMAIL_EXISTED.getMessage());
		}
		// 填寫進來的日期要在7天內
		LocalDateTime Date = LocalDateTime.now();
		LocalDateTime sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isAfter(req.getEatTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		mealsDao.insertMeals(req.getEmail(), req.getMealsName(), req.getEatTime());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 搜尋全部
	@Override
	public SelectMealsRes SelectMeals(MealsReq req) {
		BasicRes checkEmail = checkEmail(req.getEmail());
		if (checkEmail != null) {
			return (SelectMealsRes) checkEmail;
		}
		List<Meals> list = mealsDao.GetAllByemail(req.getEmail());

		return new SelectMealsRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);

	}

	// 修改
	@Override
	public BasicRes updateMeals(UpdateMealsReq req) {
		BasicRes checkEmail = checkEmail(req.getEmail());
		if (checkEmail != null) {
			return checkEmail;
		}
		// 檢查日期是不是7天內
		Meals list = mealsDao.GetByMealsId(req.getMealsId());
		LocalDateTime Date = LocalDateTime.now();
		;
		LocalDateTime sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isAfter(list.getEatTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		mealsDao.updateMeals(req.getMealsId(), req.getMealsName(), req.getEatTime());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 刪除
	@Override
	public BasicRes deleteMeals(DeleteMealsReq req) {
		BasicRes checkEmail = checkEmail(req.getEmail());
		if (checkEmail != null) {
			return checkEmail;
		}
		// 檢查日期是不是7天內
		Meals list = mealsDao.GetByMealsId(req.getMealsId());
		LocalDateTime Date = LocalDateTime.now();
		;
		LocalDateTime sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isAfter(list.getEatTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		mealsDao.deleteMeals(req.getMealsId());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 檢查email是否存在
	public BasicRes checkEmail(String email) {
		if (mealsDao.selectCountByEmail(email) == 0) {
			return new BasicRes(ResMessage.EMAIL_NOT_EXISTED.getCode(), //
					ResMessage.EMAIL_NOT_EXISTED.getMessage());
		}
		return null;
	}
}
