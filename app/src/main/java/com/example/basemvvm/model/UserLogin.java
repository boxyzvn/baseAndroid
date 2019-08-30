package com.example.basemvvm.model;

import android.util.Patterns;

public class UserLogin {
    String userName;
    String passWord;
    public UserLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getUserName()).matches();
    }

    public boolean isPasswordLengthGreaterThan5() {
        return getPassWord().length() > 5;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


}
