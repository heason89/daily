package com.example.daily.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.MoodDao;
import com.example.daily.service.ifs.MoodService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.MoodReq;
@Service
public class MoodServiceImpl implements MoodService{
	
	@Autowired
	private MoodDao moodDao;

	@Override
	public BasicRes fillinMood(MoodReq req) {
		moodDao.insertMood(req.getEmail(), req.getDate(), req.getMood(), req.getDiary());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

}
