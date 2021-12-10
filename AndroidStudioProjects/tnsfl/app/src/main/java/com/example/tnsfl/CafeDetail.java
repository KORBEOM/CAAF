package com.example.tnsfl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CafeDetail extends AppCompatActivity {

    private ImageView Backbtn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_detail);

        Intent getInt = getIntent();
        String cate = getInt.getExtras().getString("categorie");

        Backbtn = (ImageView)findViewById(R.id.backBtn2);
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,CafeInfo.class);
                startActivity(intent);
            }
        });

    }
}
