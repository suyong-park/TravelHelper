package com.hanium.travel.connect;

import com.hanium.travel.data.MyData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ConnectServer {

    String IP_ADDRESS = "http://115.85.180.60/server/";

    @FormUrlEncoded
    @POST("test.php")
    Call<MyData> sendMyData(
            @Field("movement") String[] movement,
            @Field("dest") String[] dest,
            @Field("goal") String[] goat,
            @Field("max_money") int max_money,
            @Field("min_money") int min_money
    );
}
