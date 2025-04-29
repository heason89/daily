package com.example.daily.service.ifs;

import com.example.daily.vo.*;


public interface SportsService {
	
	public BasicRes insertSports(SportsReq req);

	public BasicRes updateSports(SportsReq req);

	public BasicRes deleteSports(DeleteSportsReq req);

	public GetSportsRes searchSports(SearchSportsReq req);

	public GetSportsRes getAllSports();

}
