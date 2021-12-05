package com.example.tnsfl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CafeInfo extends AppCompatActivity {

    TextView test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_infomation);

        test = (TextView)findViewById(R.id.testview);

        Intent getInt = getIntent();
        int index = getInt.getExtras().getInt("nameid");
        setResult(RESULT_OK, getInt);
        switch (index){
            case 1:
                test.setText("리사이클");
                break;
            case 2:
                test.setText("2");
                break;
            case 3:
                test.setText("3");
                break;
            case 4:
                test.setText("4");
                break;
            case 5:
                test.setText("5");
                break;
            case 6:
                test.setText("6");
                break;
            case 7:
                test.setText("7");
                break;
            case 8:
                test.setText("8");
                break;
            case 9:
                test.setText("9");
                break;
            case 10:
                test.setText("10");
                break;
            case 11:
                test.setText("11");
                break;
            case 12:
                test.setText("12");
                break;

        }

    }
}
