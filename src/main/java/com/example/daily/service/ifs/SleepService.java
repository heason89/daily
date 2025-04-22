package com.example.daily.service.ifs;

import com.example.daily.vo.BasicRes;
import com.example.daily.vo.SelectSleepRes;
import com.example.daily.vo.SleepReq;
import com.example.daily.vo.UpdateSleepReq;

public interface SleepService {
	
	public BasicRes fillinSleep(SleepReq req);
	
	public SelectSleepRes selectSleep(SleepReq req);
	
	public BasicRes updateSleep(UpdateSleepReq req);

}
