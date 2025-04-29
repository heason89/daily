package com.example.daily.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.MoodDao;

import com.example.daily.entity.Mood;
import com.example.daily.service.ifs.MoodService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.MoodReq;

import com.example.daily.vo.SelectMoodRes;

@Service
public class MoodServiceImpl implements MoodService {

	@Autowired
	private MoodDao moodDao;

    //填寫
	@Override
	public BasicRes fillinMood(MoodReq req) {
		if (moodDao.selectCountByemail(req.getEmail()) == 1) {
			return new BasicRes(ResMessage.EMAIL_EXISTED.getCode(), //
					ResMessage.EMAIL_EXISTED.getMessage());
		}
		//填寫的資料日期要在7天內
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

    //修改
	@Override
	public BasicRes updateMood(MoodReq req) {
		BasicRes checkEmail = checkEmail(req.getEmail());
		if (checkEmail != null) {
			return checkEmail;
		}
		//7天內的才可以修改
		Mood list = moodDao.getMoodbyEmailDate(req.getEmail(), req.getDate());
		LocalDate Date = LocalDate.now();
		LocalDate sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isAfter(list.getDate())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}

		moodDao.updateByMood(req.getEmail(), req.getDate(), req.getMood(), req.getDiary());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

    //刪除
	@Override
	public BasicRes deletMood(MoodReq req) {
		BasicRes checkEmail = checkEmail(req.getEmail());
		if (checkEmail != null) {
			return checkEmail;
		}
		//7天內的才可以修改
		Mood list = moodDao.getMoodbyEmailDate(req.getEmail(), req.getDate());
		LocalDate Date = LocalDate.now();
		LocalDate sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isAfter(list.getDate())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}
		moodDao.deleteMood(req.getEmail(), req.getDate());
		;
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 檢查email
	public BasicRes checkEmail(String email) {
		if (moodDao.selectCountByemail(email) == 0) {
			return new BasicRes(ResMessage.EMAIL_NOT_EXISTED.getCode(), //
					ResMessage.EMAIL_NOT_EXISTED.getMessage());
		}
		return null;
	}

	// 搜尋
	@Override
	public SelectMoodRes selectMood(MoodReq req) {
		BasicRes checkEmail = checkEmail(req.getEmail());
		if (checkEmail != null) {
			return (SelectMoodRes) checkEmail;
		}

		List<Mood> list = moodDao.getAllMoodbyEmail(req.getEmail());

		return new SelectMoodRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}
}
