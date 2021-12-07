package com.example.tnsfl.Interface;

import com.example.tnsfl.DataSet.BoardData;
import com.example.tnsfl.DataSet.Boardexist;
import com.example.tnsfl.DataSet.CafeItem;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BoardService {

    @POST("board")
    Call<List<BoardData>> getPosts();

    @POST("comment")
    Call<List<Boardexist>> getThings();

    @GET("cafedata")
    Call<List<CafeItem>> getData(
            @Query("categorie") String categorie
    );
}
