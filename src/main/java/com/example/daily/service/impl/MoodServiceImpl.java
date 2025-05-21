package com.example.daily.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.example.daily.util.JwtUtil;
import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.MoodDao;
import com.example.daily.entity.Mood;
import com.example.daily.service.ifs.MoodService;

@Service
public class MoodServiceImpl implements MoodService {

	@Autowired
	private MoodDao moodDao;

	@Autowired
	private JwtUtil jwtUtil;

	// 填寫
	@Override
	public BasicRes fillInMood(MoodReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new BasicRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 填寫的資料日期要在7天內
//		LocalDate Date = LocalDate.now();
//		LocalDate sevenDaysAgo = Date.minusDays(7);
//		if (sevenDaysAgo.isAfter(req.getDate())) {
//			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
//					ResMessage.DATE_EXPIRED.getMessage());
//		}
		moodDao.insertMood(userId, req.getDate(), req.getMood(), req.getDiary());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 修改
	@Override
	public BasicRes updateMood(MoodReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new BasicRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		Mood list = moodDao.getMoodByUserIdDate(userId, req.getDate());
		// 檢查日期是否在7天內
		if (LocalDate.now().minusDays(7).isAfter(list.getDate())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		moodDao.updateByMood(userId, req.getDate(), req.getMood(), req.getDiary());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 刪除
	@Override
	public BasicRes deleteMood(DeleteMoodReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new BasicRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 檢查日期是否在7天內
		Mood list = moodDao.getMoodByUserIdDate(userId, req.getDate());
		if (LocalDate.now().minusDays(7).isAfter(list.getDate())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		moodDao.deleteMood(userId, req.getDate());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 取得全部
	@Override
	public GetMoodRes getMood(GetUserDataReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetMoodRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Mood> list = moodDao.getAllMoodByUserId(userId);
		return new GetMoodRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

	// 取得一個月全部
	@Override
	public GetMoodRes getMonthMood(SearchMoodInMonthReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetMoodRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Mood> list = moodDao.getMoodByUserIdMonth(userId, req.getMonth());
		return new GetMoodRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}
    //取得一天
	@Override
	public GetDateMoodRes getDateMood(MoodReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetDateMoodRes(res.getCode(), res.getMessage());
		}
		int userId = res.getUserId();
		Mood mood = moodDao.getMoodByUserIdDate(userId, req.getDate());
		return new GetDateMoodRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), mood);
	}

}
