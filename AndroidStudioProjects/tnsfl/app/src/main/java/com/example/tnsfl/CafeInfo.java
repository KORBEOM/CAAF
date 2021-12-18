package com.example.tnsfl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tnsfl.Adapter.CafeRecyclerAdapter;
import com.example.tnsfl.Adapter.MyRecyclerViewAdapter2;
import com.example.tnsfl.Adapter.RecyclerViewDecoration;
import com.example.tnsfl.DataSet.BoardData;
import com.example.tnsfl.DataSet.Boardexist;
import com.example.tnsfl.DataSet.CafeItem;
import com.example.tnsfl.Interface.BoardService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CafeInfo extends AppCompatActivity {

    private ImageView Backbtn;
    private RecyclerView recyclerView;
    private List<CafeItem> cafeData;
    private Context context;
    private static final String TAG = "cafedatadata";
    private BoardService service1;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_infomation);

        Backbtn = (ImageView)findViewById(R.id.backBtn);
        recyclerView = (RecyclerView)findViewById(R.id.cafe_recycle1);
        recyclerView.addItemDecoration(new RecyclerViewDecoration(30 , "height") );

        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeInfo.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-3-35-141-102.ap-northeast-2.compute.amazonaws.com:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service1 = retrofit.create(BoardService.class);



        Intent getInt = getIntent();
        int index = getInt.getExtras().getInt("nameid");
        setResult(RESULT_OK, getInt);
        switch (index){
            case 1:
                Calll("커피숍");
                break;
            case 2:
                Calll("만화카페");
                break;
            case 3:
                Calll("VR카페");
                break;
            case 4:
                Calll("키즈카페");
                break;
            case 5:
                Calll("스터디카페");
                break;
            case 6:
                Calll("보드게임");
                break;
            case 7:
                Calll("동물카페");
                break;
            case 8:
                Calll("낚시카페");
                break;
            case 9:
                Calll("공방카페");
                break;
            case 10:
                Calll("룸카페");
                break;
            case 11:
                Calll("방탈출");
                break;
            case 12:
                Calll("전통찻집");
                break;
        }

    }
    public void Calll(String categorie){
        Call<List<CafeItem>> call = service1.getData(categorie);

        call.enqueue(new Callback<List<CafeItem>>() {
            @Override
            public void onResponse(Call<List<CafeItem>> call, Response<List<CafeItem>> response) {
                if (response.isSuccessful()) {

                    cafeData = response.body();
                    Log.d(TAG, "onResponse:성공, 결과aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \n" + cafeData.get(0).getImage());

                    CafeRecyclerAdapter adapter = new CafeRecyclerAdapter( context,cafeData, CafeInfo.this);
                    recyclerView.setAdapter(adapter);
                } else {

                    Log.d(TAG, "onResponse:실패");
                }
            }

            @Override
            public void onFailure(Call<List<CafeItem>> call, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }
        });

    }



}

