package com.example.daily.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.SleepDao;
import com.example.daily.service.ifs.SleepService;
import com.example.daily.vo.BasicRes;
import com.example.daily.vo.SleepReq;

@Service
public class SleepServiceImpl implements SleepService{
	
	@Autowired
	private SleepDao sleepDao;

	@Override
	public BasicRes fillinSleep(SleepReq req) {
		String email = req.getEmail();
		//檢查email有沒有重複
		if(sleepDao.selectCountByemail(email) == 1) {
			return new BasicRes(ResMessage.EMAIL_DUPLICATED.getCode(), //
					ResMessage.EMAIL_DUPLICATED.getMessage());	
		}
		//檢查起床時間有沒有比起床時間晚
		if(req.getSleepTime().isAfter(req.getAwakeTime())) {
		return new BasicRes(ResMessage.PARAM_DATE_TIME_ERROR.getCode(), //
					ResMessage.PARAM_DATE_TIME_ERROR.getMessage());
		}		
		sleepDao.insertSleep(req.getEmail(), req.getSleepTime(), req.getAwakeTime(), req.getInsomnia(), req.getSleepLatency(), req.getPhone());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}
	
	

}
