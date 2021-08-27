package com.hanium.travel.connect;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ConnectServer {

    String IP_ADDRESS = "http://115.85.180.60/server";

    /*
    @POST("certification_category_data.php")
    Call<List<Recycler_category>> certification_category_data();

    @POST("certification_data.php")
    Call<List<Recycler_certification>> certification_data();

    @FormUrlEncoded
    @POST("search.php")
    Call<List<Recycler_onething>> search(
            @Field("query") String query
    );
     */
}
