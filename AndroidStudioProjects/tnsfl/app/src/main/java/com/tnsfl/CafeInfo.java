package com.tnsfl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tnsfl.Adapter.CafeRecyclerAdapter;
import com.tnsfl.Adapter.RecyclerViewDecoration;
import com.tnsfl.DataSet.CafeItem;
import com.tnsfl.Interface.BoardService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tnsfl.R;

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
                Calll("?????????");
                break;
            case 2:
                Calll("????????????");
                break;
            case 3:
                Calll("VR??????");
                break;
            case 4:
                Calll("????????????");
                break;
            case 5:
                Calll("???????????????");
                break;
            case 6:
                Calll("????????????");
                break;
            case 7:
                Calll("????????????");
                break;
            case 8:
                Calll("????????????");
                break;
            case 9:
                Calll("????????????");
                break;
            case 10:
                Calll("?????????");
                break;
            case 11:
                Calll("?????????");
                break;
            case 12:
                Calll("????????????");
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

                    CafeRecyclerAdapter adapter = new CafeRecyclerAdapter( context,cafeData, CafeInfo.this);
                    recyclerView.setAdapter(adapter);
                } else {

                    Log.d(TAG, "onResponse:??????");
                }
            }

            @Override
            public void onFailure(Call<List<CafeItem>> call, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }
        });

    }



}

