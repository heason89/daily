package com.example.daily.entity;

import com.example.daily.constants.ResMessage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {

    @Column(name ="user_name")
    private String name;

    @Id //@Id: 標示此欄位是 PK(primary key)
    @NotBlank(message = ResMessage.ConstantsMessage.PARAM_EMAIL_ERROR)
    @Column(name ="email")//@Column: 將此屬性關聯到指定的欄位，括號中的字串是欄位名稱
    private String email;

    @NotBlank(message=ResMessage.ConstantsMessage.PARAM_PASSWORD_ERROR)
    @Column(name ="password")
    private String password;

    @Column(name ="admin")
    private boolean admin;

    @Column(name ="active")
    private boolean active;

    @Column(name ="age")
    private int age;

    @Column(name ="height")
    private int height;

    @Column(name ="weight")
    private int weight;

    @Column(name ="work_type")
    private String workType;

    @Column(name ="gender")
    private boolean gender;

    public User() {
    }

    public User(String name, String email, String password, boolean admin,
                boolean active, int age, int height, int weight, String workType,
                boolean gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.active = active;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.workType = workType;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
