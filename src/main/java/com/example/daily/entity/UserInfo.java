package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class UserInfo {

    @Id //@Id: 標示此欄位是 PK(primary key)
    @Column(name ="email")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private String email;

    @Column(name ="name")
    private String name;

    @Column(name ="password")
    private String password;

    @Column(name ="age")
    private int age;

    @Column(name ="height")
    private int height;

    @Column(name ="weight")
    private int weight;

    @Column(name ="is_admin")
    private boolean is_admin;
}
