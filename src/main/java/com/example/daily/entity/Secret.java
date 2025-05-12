package com.example.daily.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="secret")
public class Secret {

    @Id
    @Column(name ="id")
    private int id;

    @Column(name ="user_secret")
    private String userSecret;

    @Column(name ="email_secret")
    private String emailSecret;

    public Secret() {
    }

    public Secret(int id, String userSecret, String emailSecret) {
        this.id = id;
        this.userSecret = userSecret;
        this.emailSecret = emailSecret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }

    public String getEmailSecret() {
        return emailSecret;
    }

    public void setEmailSecret(String emailSecret) {
        this.emailSecret = emailSecret;
    }
}
