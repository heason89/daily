package com.example.daily.dto;

import java.time.LocalDate;

public class UserDto {

    private String userName;

    private String email;

    private String password;

    private LocalDate birthdate;

    private double height;

    private double weight;

    private String workType;

    private String gender;

    private String photo;

    private String note;

    private String bodyType;

    public UserDto(String userName, String email,String password, LocalDate birthdate, double height, double weight,
                       String workType, String gender, String photo, String note, String bodyType) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.height = height;
        this.weight = weight;
        this.workType = workType;
        this.gender = gender;
        this.photo = photo;
        this.note = note;
        this.bodyType = bodyType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}
