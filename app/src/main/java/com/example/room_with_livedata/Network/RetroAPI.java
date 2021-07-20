package com.example.room_with_livedata.Network;

import com.example.room_with_livedata.models.datamodels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroAPI {
    @GET("chat.php")
    Call<List<datamodels>> getdata();
}
