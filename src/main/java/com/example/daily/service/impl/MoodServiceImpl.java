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

	@Override
	public BasicRes fillinMood(MoodReq req) {
		moodDao.insertMood(req.getEmail(), req.getDate(), req.getMood(), req.getDiary());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public BasicRes updateMood(MoodReq req) {
		Mood list = moodDao.getMoodbyEmailDate(req.getEmail(), req.getDate());
		LocalDate Date = LocalDate.now();
		LocalDate sevenDaysAgo = Date.minusDays(7);
		if (sevenDaysAgo.isBefore(list.getDate())) {
			return new BasicRes(ResMessage.DATE_EXPIRED.getCode(), //
					ResMessage.DATE_EXPIRED.getMessage());
		}

		moodDao.updateByMood(req.getEmail(), req.getDate(), req.getMood(), req.getDiary());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	@Override
	public SelectMoodRes selectMood(MoodReq req) {
		if (moodDao.selectCountByemail(req.getEmail()) == 0) {
			return new SelectMoodRes(ResMessage.EMAIL_NOT_EXISTED.getCode(), //
					ResMessage.EMAIL_NOT_EXISTED.getMessage());
		}
		List<Mood> list = moodDao.getAllMoodbyEmail(req.getEmail());

		return new SelectMoodRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), list);
	}

}
