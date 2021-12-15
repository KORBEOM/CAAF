package com.example.tnsfl.BottomNavi;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tnsfl.R;


public class FragmentPage4 extends Fragment implements View.OnClickListener {

    TextView fr4_tx1,fr4_tx2,fr4_tx3,fr4_tx4;
    Dialog customdialog,customdialog2,customdialog3,customdialog4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_4, container, false);


        customdialog = new Dialog(getActivity());
        customdialog2 = new Dialog(getActivity());
        customdialog3 = new Dialog(getActivity());
        customdialog4 = new Dialog(getActivity());

        customdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customdialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customdialog3.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customdialog4.requestWindowFeature(Window.FEATURE_NO_TITLE);

        customdialog.setContentView(R.layout.customdialog);
        customdialog2.setContentView(R.layout.customdialog2);
        customdialog3.setContentView(R.layout.customdialog3);
        customdialog4.setContentView(R.layout.customdialog4);


        view.findViewById(R.id.frg4_tx1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcustomDialog();
            }
        });
        view.findViewById(R.id.frg4_tx2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcustomDialog2();
            }
        });
        view.findViewById(R.id.frg4_tx3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcustomDialog3();
            }
        });
        view.findViewById(R.id.frg4_tx4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcustomDialog4();
            }
        });






        return view;



    }

    public void showcustomDialog(){
        customdialog.show();

        Button btnCancle1 = customdialog.findViewById(R.id.btnCancle1);
        btnCancle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                customdialog.dismiss(); // 다이얼로그 닫기
            }
        });


    }
    public void showcustomDialog2(){
        customdialog2.show();


        Button btnCancle2 = customdialog2.findViewById(R.id.btnCancle2);
        btnCancle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                customdialog2.dismiss(); // 다이얼로그 닫기
            }
        });

    }
    public void showcustomDialog3(){
        customdialog3.show();

        Button btnCancle3 = customdialog3.findViewById(R.id.btnCancle3);
        btnCancle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                customdialog3.dismiss(); // 다이얼로그 닫기
            }
        });
    }
    public void showcustomDialog4(){
        customdialog4.show();

        Button btnCancle4 = customdialog4.findViewById(R.id.btnCancle4);
        btnCancle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                customdialog4.dismiss(); // 다이얼로그 닫기
            }
        });
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {




    }


}

