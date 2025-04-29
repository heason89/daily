package com.example.daily.vo;

import com.example.daily.entity.Sports;

import java.util.List;

public class GetSportsRes extends BasicRes{

    private List<Sports> sportsList;

    public GetSportsRes() {
    }

    public GetSportsRes(int code, String message) {
        super(code, message);
    }

    public GetSportsRes(int code, String message, List<Sports> sportsList) {
        super(code, message);
        this.sportsList = sportsList;
    }

    public List<Sports> getSportsList() {
        return sportsList;
    }

    public void setSportsList(List<Sports> sportsList) {
        this.sportsList = sportsList;
    }

}
