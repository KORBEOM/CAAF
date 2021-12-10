package com.example.tnsfl.BottomNavi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tnsfl.CustomDialog;
import com.example.tnsfl.R;


public class FragmentPage4 extends Fragment implements View.OnClickListener {

    TextView fr4_tx1,fr4_tx2,fr4_tx3,fr4_tx4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_4, container, false);



        fr4_tx1 = (TextView)view.findViewById(R.id.frg4_tx1);
        fr4_tx2 = (TextView)view.findViewById(R.id.frg4_tx2);
        fr4_tx3 = (TextView)view.findViewById(R.id.frg4_tx3);
        fr4_tx4 = (TextView)view.findViewById(R.id.frg4_tx4);



        fr4_tx1.setOnClickListener(this::onClick);
        fr4_tx2.setOnClickListener(this::onClick);
        fr4_tx3.setOnClickListener(this::onClick);
        fr4_tx4.setOnClickListener(this::onClick);



        return view;



    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.frg4_tx1:Toast toast = Toast.makeText(getContext(), "gerrard218@gmail.com", Toast.LENGTH_SHORT);
                toast.show();

            case R.id.frg4_tx2:
                Toast toast1 = Toast.makeText(getContext(), "버전 2.01", Toast.LENGTH_SHORT);
                toast1.show();
                break;
            case R.id.frg4_tx3:
                Toast toast2 = Toast.makeText(getContext(), "저희 카페인 앱은 카페 정보,위치등을 공유 할 수 있는 앱입니다.", Toast.LENGTH_SHORT);
                toast2.show();
                break;
            case R.id.frg4_tx4:
                CustomDialog dlg = new CustomDialog(getActivity());
                dlg.show();
                break;

        }



    }
}

