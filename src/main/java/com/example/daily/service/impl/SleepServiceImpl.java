package com.example.daily.service.impl;

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
		if (res.getCode() != 200) {
			return new BasicRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Sleep> sleep = sleepDao.GetSleepByDate(userId, req.getDate());
		if (sleep != null) {
			sleepDao.updateSleep(sleep.getLast().getSleepId(), //
					req.getDate(), req.getInsomnia(), req.getSleepLatency(), req.getPhone(), req.getHours());
		} else {
			sleepDao.insertSleep(userId, req.getDate(), req.getInsomnia(), req.getSleepLatency(), req.getPhone(),
					req.getHours());
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public GetSleepAllRes getSleep(GetUserDataReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetSleepAllRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Sleep> list = sleepDao.GetAllByUserId(userId);
		return new GetSleepAllRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

	// 取得當天
	@Override
	public GetSleepRes getDateSleep(GetDateSleepReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetSleepRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		List<Sleep> list = sleepDao.GetSleepByDate(userId, req.getDate());
		return new GetSleepRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);

	}

	@Override
	public BasicRes updateSleep(UpdateSleepReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetSleepRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		sleepDao.updateSleep(req.getSleepId(), req.getDate(), req.getInsomnia(), req.getSleepLatency(), req.getPhone(),
				req.getHours());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes deleteSleep(DeleteSleepReq req) {
		// 驗證 token 是否有效 及 解析出 userId
		ExtractUserTokenRes res = jwtUtil.extractUserToken(req.getToken());
		if (res.getCode() != 200) {
			return new GetSleepRes(res.getCode(), res.getMessage());
		}
		// 取得 userId
		int userId = res.getUserId();
		sleepDao.deleteSleep(req.getSleepId(), userId);
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

}
