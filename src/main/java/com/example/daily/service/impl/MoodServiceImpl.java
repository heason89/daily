package com.example.daily.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.MoodDao;
import com.example.daily.dao.UserDao;
import com.example.daily.entity.Mood;
import com.example.daily.entity.User;
import com.example.daily.service.ifs.MoodService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.MoodReq;

import com.example.daily.vo.SelectMoodRes;

@Service
public class MoodServiceImpl implements MoodService {

	@Autowired
	private MoodDao moodDao;

	@Autowired
	private UserDao userDao;

	// 填寫
	@Override
	public BasicRes fillinMood(MoodReq req) {
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return res;
		}
		// 填寫的資料日期要在7天內
		LocalDate Date = LocalDate.now();
		LocalDate sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isAfter(req.getDate())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		moodDao.insertMood(req.getEmail(), req.getDate(), req.getMood(), req.getDiary());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 修改
	@Override
	public BasicRes updateMood(MoodReq req) {

		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return res;
		}
		// 7天內的才可以修改
		Mood list = moodDao.getMoodbyEmailDate(req.getEmail(), req.getDate());
		if (LocalDate.now().minusDays(7).isAfter(list.getDate())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}

		moodDao.updateByMood(req.getEmail(), req.getDate(), req.getMood(), req.getDiary());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 刪除
	@Override
	public BasicRes deletMood(MoodReq req) {
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return res;
		}
		// 7天內的才可以修改
		Mood list = moodDao.getMoodbyEmailDate(req.getEmail(), req.getDate());
		if (LocalDate.now().minusDays(7).isAfter(list.getDate())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		moodDao.deleteMood(req.getEmail(), req.getDate());
		;
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 檢查email

	// 搜尋
	@Override
	public SelectMoodRes selectMood(MoodReq req) {
		// 檢查 email 是否已存在
		User userEmail = userDao.getByEmail(req.getEmail());
		// 呼叫 checkmail 檢查
		BasicRes res = checkmail(userEmail);
		if (res.getCode() == 400) {
			return (SelectMoodRes) res;
		}

		List<Mood> list = moodDao.getAllMoodbyEmail(req.getEmail());

		return new SelectMoodRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
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
