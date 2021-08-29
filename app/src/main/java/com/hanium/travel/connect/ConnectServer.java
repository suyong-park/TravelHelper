package com.hanium.travel.connect;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ConnectServer {

    String IP_ADDRESS = "https://115.85.180.60:8080/server/";
    //String IP_ADDRESS = "https://115.85.180.60:8080/";

    @FormUrlEncoded
    @POST("test.php")
    Call<String> sendMyData(
            @Field("movement") boolean[] movement,
            @Field("dest") boolean[] dest,
            @Field("goal") boolean[] goal,
            @Field("with") boolean[] with,
            @Field("money") String[] money,
            @Field("user_info") String[] info
    );

    @FormUrlEncoded
    @POST("insert.php")
    Call<String> sendTestData(
            @Field("name") String name,
            @Field("country") String country
    );
}