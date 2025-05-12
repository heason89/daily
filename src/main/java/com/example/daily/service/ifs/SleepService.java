package com.example.daily.service.ifs;

import com.example.daily.vo.*;

public interface SleepService {
	
	public BasicRes fillInSleep(SleepReq req);
	
	public GetSleepRes getSleep(GetUserDataReq req);
	
	public BasicRes updateSleep(UpdateSleepReq req);
	
	public BasicRes deleteSleep(DeleteSleepReq req);
}
