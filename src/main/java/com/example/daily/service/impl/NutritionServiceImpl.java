package com.example.daily.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.daily.service.ifs.NutritionService;
import com.example.daily.vo.NutritionRes;

@Service
public class NutritionServiceImpl implements NutritionService {

	private final String API_KEY = "YmFFPG6L4pIqb1mvlpAb77rCtrhwiFnT5Zkkb0gj";
	private final String SEARCH_URL = "https://api.nal.usda.gov/fdc/v1/foods/search?query=%s&api_key=" + "YmFFPG6L4pIqb1mvlpAb77rCtrhwiFnT5Zkkb0gj";
	private final String DETAIL_URL = "https://api.nal.usda.gov/fdc/v1/food/%d?api_key=" + "YmFFPG6L4pIqb1mvlpAb77rCtrhwiFnT5Zkkb0gj";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public NutritionRes getNutritionByFood(String foodName) {
		String searchUrl = String.format(SEARCH_URL, foodName);
		Map searchResult = restTemplate.getForObject(searchUrl, Map.class);

		if (searchResult == null || !searchResult.containsKey("foods"))
			return new NutritionRes();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> foodList = (List<Map<String, Object>>) searchResult.get("foods");
		if (foodList.isEmpty())
			return new NutritionRes();

		int fdcId = (int) foodList.get(0).get("fdcId");

		String detailUrl = String.format(DETAIL_URL, fdcId);
		Map detail = restTemplate.getForObject(detailUrl, Map.class);
		@SuppressWarnings("unchecked")
		Map<String, Map<String, Object>> labelNutrients = (Map<String, Map<String, Object>>) detail
				.get("labelNutrients");

		return new NutritionRes(labelNutrients);

	}

}
