package com.example.tnsfl.BottomNavi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tnsfl.DataSet.BoardData;
import com.example.tnsfl.DataSet.Boardexist;
import com.example.tnsfl.Interface.BoardService;
import com.example.tnsfl.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentPage2 extends Fragment {

    private static final String TAG = "goooooo";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_2, container, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.18:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BoardService service1 = retrofit.create(BoardService.class);

        Call<List<BoardData>> call = service1.getPosts();
        Call<List<Boardexist>> call2 = service1.getThings();

        call.enqueue(new Callback<List<BoardData>>() {
            @Override
            public void onResponse(Call<List<BoardData>> call, Response<List<BoardData>> response) {
                if (response.isSuccessful()) {

                    List<BoardData> result = response.body();
                    Log.d(TAG, "onResponse:성공, 결과 \n" + result.toString());
                } else {

                    Log.d(TAG, "onResponse:실패");
                }
            }

            @Override
            public void onFailure(Call<List<BoardData>> call, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }
        });

        call2.enqueue(new Callback<List<Boardexist>>() {
            @Override
            public void onResponse(Call<List<Boardexist>> call2, Response<List<Boardexist>>response)  {
                if (response.isSuccessful()) {

                    List<Boardexist> result = response.body();
                    Log.d(TAG, "onResponse: 성공, 결과\n" + result.toString());
                } else {

                    Log.d(TAG, "onResponse: 실패");
                }
            }

            @Override
            public void onFailure(Call<List<Boardexist>> call2, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }
        });

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}

