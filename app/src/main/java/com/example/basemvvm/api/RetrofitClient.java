package com.example.basemvvm.api;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Retrofit retrofit = null;

    // other instance variables can be here

    public RetrofitClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient();
        String baseURL;
            baseURL = ConstantApi.BASE_URL_DEV;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL).client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
    }

    public Retrofit getRetrofitClient() {
        return retrofit;
    }

    public APIServiceDao getAPIServiceBase() {
        return getRetrofitClient().create(APIServiceDao.class);
    }

    public APIServiceDao getAPIServiceByUrl(String url) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient();
        Retrofit re = new Retrofit.Builder()
                .baseUrl(url).client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return re.create(APIServiceDao.class);
    }

}
