package com.example.basemvvm.viewmodel;

import android.view.View;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.basemvvm.model.UserLogin;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    public MutableLiveData<Boolean> checkb = new MutableLiveData<>();

    public final ObservableBoolean checkbox = new ObservableBoolean();

    private MutableLiveData<UserLogin> userMutableLiveData;

    public boolean isClick = false;
    public MutableLiveData<UserLogin> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public MutableLiveData<Boolean> getCheckBox() {
        return checkb;

    }

    public void onClick(View v) {
        UserLogin loginUser = new UserLogin(EmailAddress.getValue(), Password.getValue());
        userMutableLiveData.setValue(loginUser);
        isClick = true;
        if (checkb.getValue() == null)
            checkb.setValue(false);
        else
            checkb.setValue(checkb.getValue());


    }

    public void onEnterPress() {
        UserLogin loginUser = new UserLogin(EmailAddress.getValue(), Password.getValue());
        userMutableLiveData.setValue(loginUser);
        isClick = true;
        if (checkb.getValue() == null)
            checkb.setValue(false);
        else
            checkb.setValue(checkb.getValue());


    }

}
