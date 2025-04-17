package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Mood {

    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="time")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private LocalDate time;

    @Id
    @Column(name ="email")
    private String email;

    @Column(name ="diary")
    private String diary;

    @Column(name ="point")
    private int point;
}
