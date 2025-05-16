package com.example.daily.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.daily.util.JwtUtil;
import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.MealsDao;
import com.example.daily.entity.Meals;
import com.example.daily.service.ifs.MealsService;

@Service
public class MealsServiceImpl implements MealsService {

	@Autowired
	private MealsDao mealsDao;

	@Autowired
	private JwtUtil jwtUtil;

	// 填寫
	@Override
	public BasicRes fillInMeals(MealsReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new BasicRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 呼叫 checkDate 檢查日期
		BasicRes date = checkDate(req.getEatTime());
		if (date.getCode() == 400) {
			return date;
		}
		mealsDao.insertMeals(userId, req.getMealsName(), req.getEatTime(),req.getMealsType());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 搜尋全部
	@Override
	public GetMealsRes getMeals(GetUserDataReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetMealsRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Meals> list = mealsDao.GetAllByUserId(userId);
		return new GetMealsRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

	// 更新
	@Override
	public BasicRes updateMeals(UpdateMealsReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetMealsRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 檢查日期是不是7天內
		Meals list = mealsDao.GetByMealsId(req.getMealsId(), userId);
		if (list == null) {
			return new BasicRes(ResMessage.ID_MISMATCH.getCode(), //
					ResMessage.ID_MISMATCH.getMessage());
		}
		// 檢查更新的日期是不是7天內
		// 呼叫 checkDate 檢查日期
		BasicRes date = checkDate(req.getEatTime());
		if (date.getCode() == 400) {
			return date;
		}
		mealsDao.updateMeals(req.getMealsId(), req.getMealsName(), req.getEatTime(), req.getMealsType());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 刪除
	@Override
	public BasicRes deleteMeals(DeleteMealsReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetMealsRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 檢查日期是不是7天內
		Meals list = mealsDao.GetByMealsId(req.getMealsId(), userId);
		// 呼叫 checkDate 檢查日期
		BasicRes date = checkDate(list.getEatTime());
		if (res.getCode() == 400) {
			return date;
		}
		mealsDao.deleteMeals(req.getMealsId());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 檢查日期
	private BasicRes checkDate(LocalDate eatTime) {
		// 檢查日期是不是7天內
		if (LocalDate.now().minusDays(7).isAfter(eatTime)) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

//搜尋當天
	@Override
	public GetMealsRes getDateMeals(GetDateMealsReq req) {
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetMealsRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Meals> list = mealsDao.GetDateMeals(userId, req.getDate());
		return new GetMealsRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);

	}
}
