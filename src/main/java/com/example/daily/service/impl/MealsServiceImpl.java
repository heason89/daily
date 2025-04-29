package com.example.daily.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.MealsDao;
import com.example.daily.dao.UserDao;
import com.example.daily.entity.Meals;
import com.example.daily.entity.Mood;
import com.example.daily.entity.User;
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
	@Autowired
	private UserDao userDao;

	// 填寫
	@Override
	public BasicRes fillinMeals(MealsReq req) {
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return res;
		}
		// 填寫進來的日期要在7天內

		if (LocalDateTime.now().minusDays(7).isAfter(req.getEatTime())) {
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
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return (SelectMealsRes) res;
		}
		List<Meals> list = mealsDao.GetAllByemail(req.getEmail());

		return new SelectMealsRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);

	}

	// 修改
	@Override
	public BasicRes updateMeals(UpdateMealsReq req) {
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return res;
		}
		// 檢查日期是不是7天內
		Meals list = mealsDao.GetByMealsId(req.getMealsId());

		if (LocalDateTime.now().minusDays(7).isAfter(list.getEatTime())) {
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
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return res;
		}
		// 檢查日期是不是7天內
		Meals list = mealsDao.GetByMealsId(req.getMealsId());

		if (LocalDateTime.now().minusDays(7).isAfter(list.getEatTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		mealsDao.deleteMeals(req.getMealsId());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	private BasicRes checkmail(User usermail) {
		// 帳號不存在
		if (usermail == null) {
			return new BasicRes(ResMessage.EMAIL_NOT_EXISTED.getCode(), //
					ResMessage.EMAIL_NOT_EXISTED.getMessage());
		}
		// 帳號已註銷
		if (!usermail.isActive()) {
			return new BasicRes(ResMessage.EMAIL_HAS_BEEN_CANCELED.getCode(), //
					ResMessage.EMAIL_HAS_BEEN_CANCELED.getMessage());
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}
}
