package com.example.daily.service.impl;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.SleepDao;

import com.example.daily.entity.Sleep;
import com.example.daily.service.ifs.SleepService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.DeleteSleepReq;
import com.example.daily.vo.SelectSleepRes;
import com.example.daily.vo.SleepReq;
import com.example.daily.vo.UpdateSleepReq;

@Service
public class SleepServiceImpl implements SleepService {

	@Autowired
	private SleepDao sleepDao;

	@Override
	public BasicRes fillinSleep(SleepReq req) {
		String email = req.getEmail();
		// 檢查email有沒有重複
		if (sleepDao.selectCountByemail(email) == 1) {
			return new BasicRes(ResMessage.EMAIL_DUPLICATED.getCode(), //
					ResMessage.EMAIL_DUPLICATED.getMessage());
		}
		//填寫進來的日期要在7天內
		LocalDateTime Date = LocalDateTime.now();
		LocalDateTime sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isAfter(req.getSleepTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		// 檢查起床時間有沒有比起床時間晚
		if (req.getSleepTime().isAfter(req.getAwakeTime())) {
			return new BasicRes(ResMessage.PARAM_DATE_TIME_ERROR.getCode(), //
					ResMessage.PARAM_DATE_TIME_ERROR.getMessage());
		}
		sleepDao.insertSleep(req.getEmail(), req.getSleepTime(), req.getAwakeTime(), req.getInsomnia(),
				req.getSleepLatency(), req.getPhone());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public SelectSleepRes selectSleep(SleepReq req) {
		if (sleepDao.selectCountByemail(req.getEmail()) == 0) {
			return new SelectSleepRes(ResMessage.EMAIL_NOT_EXISTED.getCode(), //
					ResMessage.EMAIL_NOT_EXISTED.getMessage());
		}
		List<Sleep> list = sleepDao.GetAllByEmail(req.getEmail());

		return new SelectSleepRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

	@Override
	public BasicRes updateSleep(UpdateSleepReq req) {
		BasicRes checkEmail = checkEmail(req.getEmail());
		if (checkEmail != null) {
			return checkEmail;
		}
		//檢查日期是否在7天內
		Sleep list = sleepDao.GetBySleepId(req.getSleepId());
		LocalDateTime Date = LocalDateTime.now();
		LocalDateTime sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isAfter(list.getSleepTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		if(req.getSleepTime().isEqual(Date)) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		// 檢查起床時間有沒有比起床時間晚
		if (req.getSleepTime().isAfter(req.getAwakeTime())) {
			return new BasicRes(ResMessage.PARAM_DATE_TIME_ERROR.getCode(), //
					ResMessage.PARAM_DATE_TIME_ERROR.getMessage());
		}
		sleepDao.updateSleep(req.getSleepId(), req.getSleepTime(), req.getAwakeTime(), req.getInsomnia(),
				req.getSleepLatency(), req.getPhone());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes deleteSleep(DeleteSleepReq req) {
		BasicRes checkEmail = checkEmail(req.getEmail());
		if (checkEmail != null) {
			return checkEmail;
		}
		//檢查日期是否在7天內
		Sleep list = sleepDao.GetBySleepId(req.getSleepId());
		LocalDateTime Date = LocalDateTime.now();
		LocalDateTime sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isAfter(list.getSleepTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		sleepDao.deleteSleep(req.getEmail(), req.getSleepId());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}
	public BasicRes checkEmail(String email) {
		if (sleepDao.selectCountByemail(email) == 0) {
			return new BasicRes(ResMessage.EMAIL_NOT_EXISTED.getCode(), //
					ResMessage.EMAIL_NOT_EXISTED.getMessage());
		}
		return null;
	}
}
