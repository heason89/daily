package com.example.daily.vo;

import java.util.Map;

public class NutritionRes {
	
	private Map<String, Map<String, Object>> nutrients;

    public NutritionRes() {}

    public NutritionRes(Map<String, Map<String, Object>> nutrients) {
        this.nutrients = nutrients;
    }

    public Map<String, Map<String, Object>> getNutrients() {
        return nutrients;
    }

    public void setNutrients(Map<String, Map<String, Object>> nutrients) {
        this.nutrients = nutrients;
    }

}
