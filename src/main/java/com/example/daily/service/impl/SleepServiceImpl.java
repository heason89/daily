package com.example.daily.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.example.daily.util.JwtUtil;
import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.SleepDao;
import com.example.daily.entity.Sleep;
import com.example.daily.service.ifs.SleepService;

@Service
public class SleepServiceImpl implements SleepService {

	@Autowired
	private SleepDao sleepDao;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public BasicRes fillInSleep(SleepReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new BasicRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		// 檢查時間
		BasicRes date = checkReq(req.getSleepTime(), req.getAwakeTime());
		if (date.getCode() == 400) {
			return date;
		}
		sleepDao.insertSleep(userId, req.getSleepTime(), req.getAwakeTime(), req.getInsomnia(),
				req.getSleepLatency(), req.getPhone(), req.getHours());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public GetSleepRes getSleep(GetUserDataReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new GetSleepRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Sleep> list = sleepDao.GetAllByUserId(userId);
		return new GetSleepRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

	@Override
	public BasicRes updateSleep(UpdateSleepReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new GetSleepRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		Sleep list = sleepDao.GetBySleepId(req.getSleepId(),userId);
		// 檢查時間
		BasicRes date = checkReq(req.getSleepTime(), req.getAwakeTime());
		if (date.getCode() == 400) {
			return date;
		}
		// 檢查日期是否在7天內
		if (LocalDateTime.now().minusDays(7).isAfter(list.getSleepTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		sleepDao.updateSleep(req.getSleepId(), req.getSleepTime(), req.getAwakeTime(), req.getInsomnia(),
				req.getSleepLatency(), req.getPhone(), req.getHours());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes deleteSleep(DeleteSleepReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if(res.getCode()!=200)
		{
			return new GetSleepRes(res.getCode(),res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		Sleep list = sleepDao.GetBySleepId(req.getSleepId(),userId);
		// 檢查日期是否在7天內
		if (LocalDateTime.now().minusDays(7).isAfter(list.getSleepTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		sleepDao.deleteSleep(req.getSleepId(),userId);
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	private BasicRes checkReq(LocalDateTime SleepTime, LocalDateTime awakeTime) {
		// 檢查日期是否在7天內
		if (SleepTime.isBefore(LocalDateTime.now().minusDays(7))) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		// 檢查起床時間有沒有比起床時間晚
		if (SleepTime.isAfter(awakeTime)) {
			return new BasicRes(ResMessage.PARAM_DATE_TIME_ERROR.getCode(), //
					ResMessage.PARAM_DATE_TIME_ERROR.getMessage());
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}
}
