package com.example.daily.vo;

import java.util.List;

import com.example.daily.entity.Mood;

public class SelectMoodRes extends BasicRes{
	
	private List<Mood> moodlist;

	public SelectMoodRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectMoodRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public SelectMoodRes(int code, String message, List<Mood> moodlist) {
		super(code, message);
		this.moodlist = moodlist;
	}

	public List<Mood> getMoodlist() {
		return moodlist;
	}

	public void setMoodlist(List<Mood> moodlist) {
		this.moodlist = moodlist;
	}

}
