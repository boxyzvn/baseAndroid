package com.example.basemvvm.api.callback;

public  interface CallBackLogin{
    void onComplete(String userName, String pass);
    void onError(String errorCode);
}