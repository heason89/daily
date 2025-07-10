package com.example.daily.vo;

import com.example.daily.entity.Exercise;
import com.example.daily.entity.Meals;
import com.example.daily.entity.Sleep;

import java.util.List;

public class GetDataRes extends BasicRes{

    private List<Exercise> exerciseList;

    private List<Meals> mealsList;

    private Sleep sleepList;

    public GetDataRes() {
    }

    public GetDataRes(int code, String message) {
        super(code, message);
    }

    public GetDataRes(int code, String message, List<Exercise> exerciseList, List<Meals> mealsList,//
                      Sleep sleepList) {
        super(code, message);
        this.exerciseList = exerciseList;
        this.mealsList = mealsList;
        this.sleepList = sleepList;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public List<Meals> getMealsList() {
        return mealsList;
    }

    public void setMealsList(List<Meals> mealsList) {
        this.mealsList = mealsList;
    }

    public Sleep getSleepList() {
        return sleepList;
    }

    public void setSleepList(Sleep sleepList) {
        this.sleepList = sleepList;
    }
}
