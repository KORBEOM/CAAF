package com.example.tnsfl.Interface;

import com.example.tnsfl.DataSet.kakaResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface kakaoApi {

    @GET("v2/local/search/keyword.json")
    Call<kakaResult> getSearch(
            @Header("Authorization") String key,
            @Query("query") String query,
            @Query("x") String x,
            @Query("y") String y,
            @Query("radius") Integer radius
    );
}
