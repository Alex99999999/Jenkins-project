package com.cool.application.entity;

import com.cool.application.annotation.DbName;
import com.cool.application.annotation.Nullable;
import com.cool.application.servlet.parameters.UserParameters;

import java.io.Serializable;

public class User implements Serializable {

    private long id;

    @Nullable
    @DbName(name = UserParameters.FAMILY_NAME)
    private String familyName;

    @Nullable(nullable = false)
    @DbName(name = UserParameters.GIVEN_NAME)
    private String givenName;

    @Nullable
    @DbName(name = UserParameters.PHONE_NUMBER)
    private String phoneNumber;

    @Nullable
    @DbName(name = UserParameters.AGE)
    private int age;

    public User() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }

}