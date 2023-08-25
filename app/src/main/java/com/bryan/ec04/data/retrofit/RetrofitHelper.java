package com.bryan.ec04.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitHelper {
    public static Retrofit instance;
    public static MenuInterface service;

    public static Retrofit getInstance(){

        if(instance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getLogginBuilder().build())
                    .build();
            instance = retrofit;
        }
            return instance;
    }


    public static OkHttpClient.Builder getLogginBuilder(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder;
    }

    public static MenuInterface getService(){
        if(service == null){
            service = getInstance().create(MenuInterface.class);
        }
        return service;
    }
}
