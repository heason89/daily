package com.example.daily.vo;

import com.example.daily.constants.ResMessage;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class GetByDateReq extends GetUserDataReq{

    @NotNull(message= ResMessage.ConstantsMessage.PARAM_DATE_ERROR)
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }
}
