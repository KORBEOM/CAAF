package com.tnsfl.Interface;

import com.tnsfl.DataSet.BoardData;
import com.tnsfl.DataSet.Boardexist;
import com.tnsfl.DataSet.CafeItem;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @POST("boardsearch")
    Call<List<BoardData>> getBoard(
            @Query("title") String title
    );

    @GET("boardData")
    Call<String> setBoard(
            @Query("title") String title,
            @Query("categorie") String categorie,
            @Query("id") String id,
            @Query("content")  String content
    );

    @GET("cafeName")
    Call<List<CafeItem>> getCafe(
            @Query("name") String name
    );



}
