package com.example.basemvvm.api;


import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basemvvm.api.callback.CallBackLogin;
import com.example.basemvvm.utils.UtilJson;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ApiServiceManager extends AppCompatActivity {
    private static ApiServiceManager INSTANCE;
    public static final String SALT_STRING = "@4%a4vN90Zjkzz1-1";
    private APIServiceDao mApiServiceDao;
    // other instance variables can be here

    private ApiServiceManager() {
        mApiServiceDao = new RetrofitClient().getAPIServiceBase();
    }

    public static ApiServiceManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApiServiceManager();
        }
        return INSTANCE;
    }

    public void login(final String email, final String pass, final String uuid, final String appVer, final CallBackLogin callBack) {
        mApiServiceDao.login(email, SALT_STRING + pass, appVer, uuid, "1").enqueue(new Callback<ResponseBase>() {
            @Override
            public void onResponse(Call<ResponseBase> call, Response<ResponseBase> response) {
                if (response.errorBody() != null) {
                    callBack.onError(response.errorBody().toString());
                } else {
                    if (response.code() == 200) {
                        Gson gson = new Gson();
                        try {
                            JSONObject jsonObject = new JSONObject(UtilJson.toJson(response.body().data));
                            callBack.onComplete("", "");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        callBack.onError(response.errorBody().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBase> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
