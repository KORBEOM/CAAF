package com.tnsfl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import tnsfl.R;

public class LodingActivity extends AppCompatActivity {

    private static final String TAG = "aaaaaaaaaaaaaaaaaaaaaaa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        startLoading();
    }
    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(LodingActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 400);
    }
}
