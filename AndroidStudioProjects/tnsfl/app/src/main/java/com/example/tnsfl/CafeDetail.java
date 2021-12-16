package com.example.tnsfl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CafeDetail extends AppCompatActivity {

    private ImageView Backbtn;
    private TextView cafeNAME;
    private TextView cafePHONE;
    private TextView cafeCATE;
    private TextView cafeOLD;
    private TextView cafeNEW;
    private RatingBar ratingbar;
    private static final String TAG = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_detail);
        ratingbar = (RatingBar) findViewById(R.id.ratingBar);

        cafeCATE = findViewById(R.id.cafecategorie);
        cafeNAME = findViewById(R.id.cafename);
        cafePHONE = findViewById(R.id.cafephone);
        cafeOLD = findViewById(R.id.oldaddress);
        cafeNEW = findViewById(R.id.newaddress);

        Intent getInt = getIntent();
        String cate = getInt.getExtras().getString("categorie");
        String cafe_name = getInt.getExtras().getString("cafeName");
        String cafe_phone = getInt.getExtras().getString("cafePhone");
        String cafe_old = getInt.getExtras().getString("cafeOld");
        String cafe_new = getInt.getExtras().getString("cafeNew");

        cafeNAME.setText("카페 이름: " + cafe_name);
        cafeCATE.setText("카페 종류: " + cate);
        cafePHONE.setText("전화 번호: " + cafe_phone);
        cafeOLD.setText("지번: " + cafe_old);
        cafeNEW.setText("도로명: " + cafe_new);

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Log.d(TAG , String.valueOf(ratingBar.getRating()));
                if(ratingBar.getRating() < 1.0f){
                    ratingBar.setRating(1);
                }
            }
        });
        Log.d(TAG , "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        Backbtn = (ImageView)findViewById(R.id.backBtn2);
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeDetail.this,CafeInfo.class);
                switch (cate){
                    case "커피숍":
                        intent.putExtra("nameid",1);
                        startActivity(intent);
                        break;
                    case "만화카페":
                        intent.putExtra("nameid",2);
                        startActivity(intent);
                        break;
                    case "VR카페":
                        intent.putExtra("nameid",3);
                        startActivity(intent);
                        break;
                    case "키즈카페":
                        intent.putExtra("nameid",4);
                        startActivity(intent);
                        break;
                    case "스터디카페":
                        intent.putExtra("nameid",5);
                        startActivity(intent);
                        break;
                    case "보드게임":
                        intent.putExtra("nameid",6);
                        startActivity(intent);
                        break;
                    case "동물카페":
                        intent.putExtra("nameid",7);
                        startActivity(intent);
                        break;
                    case "낚시카페":
                        intent.putExtra("nameid",8);
                        startActivity(intent);
                        break;
                    case "공방카페":
                        intent.putExtra("nameid",9);
                        startActivity(intent);
                        break;
                    case "룸카페":
                        intent.putExtra("nameid",10);
                        startActivity(intent);
                        break;
                    case "방탈출":
                        intent.putExtra("nameid",11);
                        startActivity(intent);
                        break;
                    case "전통찻집":
                        intent.putExtra("nameid",12);
                        startActivity(intent);
                        break;

                }

            }
        });

    }

}
