package com.example.daily.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.SleepDao;

import com.example.daily.entity.Sleep;
import com.example.daily.service.ifs.SleepService;
import com.example.daily.vo.BasicRes;

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
		List<Sleep> list = sleepDao.selectByemail(req.getEmail());

		return new SelectSleepRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

	@Override
	public BasicRes updateSleep(UpdateSleepReq req) {
		// 檢查起床時間有沒有比起床時間晚
		if (req.getSleepTime().isAfter(req.getAwakeTime())) {
			return new BasicRes(ResMessage.PARAM_DATE_TIME_ERROR.getCode(), //
					ResMessage.PARAM_DATE_TIME_ERROR.getMessage());
		}
		sleepDao.updateBySleep(req.getSleepId(), req.getSleepTime(), req.getAwakeTime(), req.getInsomnia(),
				req.getSleepLatency(), req.getPhone());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

}
