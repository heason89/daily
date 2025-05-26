package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotNull;

public class WeightReq extends GetUserDataReq{

    @NotNull(message = ResMessage.ConstantsMessage.PARAM_WEIGHT_ERROR)
    private double weight;

    public double getWeight() {
        return weight;
    }
}
