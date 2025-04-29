package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotBlank;

public class DeleteSportsReq {

    @NotBlank(message= ResMessage.ConstantsMessage.PARAM_SPORTS_NAME_ERROR)
    private String sportsName;

    public String getSportsName() {
        return sportsName;
    }
}
