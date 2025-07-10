package com.example.daily.service.ifs;

import com.example.daily.vo.*;

public interface SleepService {
	
	public BasicRes fillInSleep(SleepReq req);
	
	public GetSleepAllRes getSleep(GetUserDataReq req);
	
	public GetSleepRes getDateSleep(GetDateSleepReq req);
	
	public BasicRes updateSleep(UpdateSleepReq req);
	
	public BasicRes deleteSleep(DeleteSleepReq req);
}
