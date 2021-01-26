package com.google.androidcore.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "register")
public class Register {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "reg_id")
    @NonNull
    private int id;

    @ColumnInfo(name = "emailAddress")
    @NonNull
    private String emailAddress;

    @ColumnInfo(name = "password")
    @NonNull
    private String password;

    public Register(@NonNull String emailAddress, @NonNull String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(@NonNull String title) {
        this.emailAddress = title;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
