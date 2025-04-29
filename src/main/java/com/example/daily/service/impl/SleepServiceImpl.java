package com.example.daily.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.SleepDao;
import com.example.daily.dao.UserDao;
import com.example.daily.entity.Sleep;
import com.example.daily.entity.User;
import com.example.daily.service.ifs.SleepService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.DeleteSleepReq;
import com.example.daily.vo.ExerciseReq;
import com.example.daily.vo.SelectSleepRes;
import com.example.daily.vo.SleepReq;
import com.example.daily.vo.UpdateSleepReq;

@Service
public class SleepServiceImpl implements SleepService {

	@Autowired
	private SleepDao sleepDao;

	@Autowired
	private UserDao userDao;

	@Override
	public BasicRes fillinSleep(SleepReq req) {
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return res;
		}
		// 檢查時間
		res = checkReq(req.getSleepTime(), req.getAwakeTime());
		if (res.getCode() == 400) {
			return res;
		}
		sleepDao.insertSleep(req.getEmail(), req.getSleepTime(), req.getAwakeTime(), req.getInsomnia(),
				req.getSleepLatency(), req.getPhone());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 搜尋
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
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return res;
		}
		// 檢查時間
		res = checkReq(req.getSleepTime(), req.getAwakeTime());
		if (res.getCode() == 400) {
			return res;
		}
		// 檢查日期是否在7天內
		Sleep list = sleepDao.GetBySleepId(req.getSleepId());
		if (LocalDateTime.now().minusDays(7).isAfter(list.getSleepTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		sleepDao.updateSleep(req.getSleepId(), req.getSleepTime(), req.getAwakeTime(), req.getInsomnia(),
				req.getSleepLatency(), req.getPhone());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes deleteSleep(DeleteSleepReq req) {
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return res;
		}
		// 檢查日期是否在7天內
		Sleep list = sleepDao.GetBySleepId(req.getSleepId());
		if (LocalDateTime.now().minusDays(7).isAfter(list.getSleepTime())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		sleepDao.deleteSleep(req.getEmail(), req.getSleepId());
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
