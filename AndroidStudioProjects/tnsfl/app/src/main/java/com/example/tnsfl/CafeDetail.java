package com.example.tnsfl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tnsfl.Adapter.CafeRecyclerAdapter;
import com.example.tnsfl.DataSet.CafeItem;
import com.example.tnsfl.Interface.BoardService;

import java.util.Base64;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CafeDetail extends AppCompatActivity {

    private ImageView outside;
    private ImageView inside;
    private ImageView Backbtn;
    private TextView cafeNAME;
    private TextView cafePHONE;
    private TextView cafeCATE;
    private TextView cafeOLD;
    private TextView cafeNEW;
    private BoardService service1;
    private List<CafeItem> cafeData;
    SpannableStringBuilder builder;
    SpannableStringBuilder builder2;
    SpannableStringBuilder builder3;
    SpannableStringBuilder builder4;
    SpannableStringBuilder builder5;
    StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
    RelativeSizeSpan sizeBigSpan = new RelativeSizeSpan(1.5f);
    private static final String TAG = "gasdgasdgasdgdwgwgwgwwbwbwbwbwbwbwbwbwbwbwbwbw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_detail);

        Matrix matrix = new Matrix();
        matrix.preScale(1.5f,3.0f);

        outside =(ImageView) findViewById(R.id.outside);
        inside = (ImageView) findViewById(R.id.inside);
        cafeCATE = findViewById(R.id.cafecategorie);
        cafeNAME = findViewById(R.id.cafename);
        cafePHONE = findViewById(R.id.cafephone);
        cafeOLD = findViewById(R.id.oldaddress);
        cafeNEW = findViewById(R.id.newaddress);

        Intent getInt = getIntent();
        String cafe_name = getInt.getExtras().getString("cafeName");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-3-35-141-102.ap-northeast-2.compute.amazonaws.com:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service1 = retrofit.create(BoardService.class);

        Call<List<CafeItem>> call = service1.getCafe(cafe_name);

        call.enqueue(new Callback<List<CafeItem>>() {
            @Override
            public void onResponse(Call<List<CafeItem>> call, Response<List<CafeItem>> response) {
                if (response.isSuccessful()) {

                    cafeData = response.body();
                    Log.d(TAG, "onResponse:성공, 결과11111111111111111111111111111 \n" + cafeData.get(0).getImage());

                    if(cafeData.get(0).getImage() != null){

                        String imageString = cafeData.get(0).getImage();
                        Log.d(TAG,imageString);
                        Bitmap decodeByte = BitmapFactory.decodeByteArray(Base64.getDecoder().decode(imageString),0,Base64.getDecoder().decode(imageString).length );
                        Bitmap bitmap = Bitmap.createBitmap(decodeByte, 0, 0, decodeByte.getWidth(), decodeByte.getHeight(), matrix, false);
                        outside.setImageBitmap(bitmap);

                    }
                    if(cafeData.get(0).getImage2() != null){
                        Log.d(TAG,"2i2i2i22i2i2i2i2i2i22i2i2i2i2i2i2i22i2i2i2i2i");
                        String imageString2 = cafeData.get(0).getImage2();
                        Bitmap decodeByte2 = BitmapFactory.decodeByteArray(Base64.getDecoder().decode(imageString2),0,Base64.getDecoder().decode(imageString2).length );
                        Bitmap bitmap2 = Bitmap.createBitmap(decodeByte2, 0, 0, decodeByte2.getWidth(), decodeByte2.getHeight(), matrix, false);
                        inside.setImageBitmap(bitmap2);
                    }
                    cafeNAME.setText("카페 이름: " + cafeData.get(0).getTitle());
                    cafeCATE.setText("카페 종류: " + cafeData.get(0).getCategorie());
                    cafePHONE.setText("전화 번호: " + cafeData.get(0).getPhone());
                    cafeOLD.setText("지번: " + cafeData.get(0).getLocation());
                    cafeNEW.setText("도로명: " + cafeData.get(0).getLocation2());

                    String cateData =cafeCATE.getText().toString();
                    String nameData = cafeNAME.getText().toString();
                    String phoneData = cafePHONE.getText().toString();
                    String oldData = cafeOLD.getText().toString();
                    String newData = cafeNEW.getText().toString();

                    builder = new SpannableStringBuilder(cateData);
                    builder2 = new SpannableStringBuilder(nameData);
                    builder3 = new SpannableStringBuilder(phoneData);
                    builder4 = new SpannableStringBuilder(oldData);
                    builder5 = new SpannableStringBuilder(newData);

                    builder.setSpan(boldSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    builder.setSpan(sizeBigSpan,0,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    builder2.setSpan(boldSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    builder2.setSpan(sizeBigSpan,0,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    builder3.setSpan(boldSpan,0,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    builder3.setSpan(sizeBigSpan,0,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    builder4.setSpan(boldSpan,0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    builder4.setSpan(sizeBigSpan,0,2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    builder5.setSpan(boldSpan,0,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    builder5.setSpan(sizeBigSpan,0,3,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    cafeCATE.setText(builder);
                    cafeNAME.setText(builder2);
                    cafePHONE.setText(builder3);
                    cafeOLD.setText(builder4);
                    cafeNEW.setText(builder5);

                } else {

                    Log.d(TAG, "onResponse:실패");
                }
            }

            @Override
            public void onFailure(Call<List<CafeItem>> call, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }
        });



//        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                Log.d(TAG , String.valueOf(ratingBar.getRating()));
//                if(ratingBar.getRating() < 1.0f){
//                    ratingBar.setRating(1);
//                }
//            }
//        });
        Log.d(TAG , "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        Backbtn = (ImageView)findViewById(R.id.backBtn2);
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeDetail.this,CafeInfo.class);
                switch (cafeData.get(0).getCategorie()){
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

