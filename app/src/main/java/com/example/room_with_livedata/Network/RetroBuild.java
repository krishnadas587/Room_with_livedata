package com.example.room_with_livedata.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroBuild {
    private static String URL="https://apmslive.com/android/";
    Retrofit retrofit=new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
    public RetroAPI API=retrofit.create(RetroAPI.class);
}
