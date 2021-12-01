package com.example.tnsfl.Interface;

import com.example.tnsfl.DataSet.BoardData;
import com.example.tnsfl.DataSet.Boardexist;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BoardService {

    @POST("board")
    Call<List<BoardData>> getPosts();

    @POST("comment")
    Call<List<Boardexist>> getThings();
}
