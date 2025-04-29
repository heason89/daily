package com.example.daily.service.ifs;

import com.example.daily.vo.BasicRes;
import com.example.daily.vo.MoodReq;
import com.example.daily.vo.SelectMoodRes;


public interface MoodService {
	
	public BasicRes fillinMood(MoodReq  req);
	
	public BasicRes updateMood(MoodReq  req);
	
	public BasicRes deletMood(MoodReq  req);
	
	public SelectMoodRes selectMood(MoodReq  req);

}
