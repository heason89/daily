package com.example.daily.service.impl;

import com.example.daily.entity.Sports;
import com.example.daily.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daily.constants.ResMessage;
import com.example.daily.dao.SportsDao;
import com.example.daily.service.ifs.SportsService;

import java.util.List;

@Service
public class SportsServiceImpl implements SportsService{
	
	@Autowired
	private SportsDao sportsDao;

	// 新增運動項目
	@Override
	public BasicRes insertSports(SportsReq req) {
		// 檢查運動項目是否已存在
		Sports sportsName = sportsDao.getBySportsName(req.getSportsName());
		// 運動項目存在
		if (sportsName != null){
			return new BasicRes(ResMessage.SPORTS_EXISTED.getCode(),//
					ResMessage.SPORTS_EXISTED.getMessage());
		}
		sportsDao.insertSports(req.getSportsName(), req.getSportsType(), req.getConsume());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 更新運動項目
	@Override
	public BasicRes updateSports(SportsReq req) {
		// 檢查運動項目是否已存在
		Sports sportsName = sportsDao.getBySportsName(req.getSportsName());
		// 運動項目不存在
		if (sportsName == null){
			return new BasicRes(ResMessage.SPORTS_NOT_EXISTED.getCode(),//
					ResMessage.SPORTS_NOT_EXISTED.getMessage());
		}
		sportsDao.updateSports(req.getSportsName(),req.getSportsType(),req.getConsume());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 刪除運動項目
	@Override
	public BasicRes deleteSports(DeleteSportsReq req) {
		// 檢查運動項目是否已存在
		Sports sportsName = sportsDao.getBySportsName(req.getSportsName());
		// 運動項目不存在
		if (sportsName == null){
			return new BasicRes(ResMessage.SPORTS_NOT_EXISTED.getCode(),//
					ResMessage.SPORTS_NOT_EXISTED.getMessage());
		}
		sportsDao.deleteSport(req.getSportsName());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	// 搜尋運動項目
	@Override
	public GetSportsRes searchSports(SearchSportsReq req) {
		List<Sports> list = sportsDao.searchSports(req.getSportsName(), req.getSportsType());
		return new GetSportsRes(ResMessage.SUCCESS.getCode(),//
				ResMessage.SUCCESS.getMessage(),list);
	}

	// 取得所有運動項目
	@Override
	public GetSportsRes getAllSports() {
		List<Sports> list = sportsDao.getAllSports();
		return new GetSportsRes(ResMessage.SUCCESS.getCode(),//
				ResMessage.SUCCESS.getMessage(),list);
	}

}
