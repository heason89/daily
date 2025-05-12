package com.example.daily.service.ifs;

import com.example.daily.vo.*;


public interface MoodService {
	
	public BasicRes fillInMood(MoodReq  req);
	
	public BasicRes updateMood(MoodReq  req);
	
	public BasicRes deleteMood(DeleteMoodReq req);
	
	public GetMoodRes getMood(GetUserDataReq req);
}
