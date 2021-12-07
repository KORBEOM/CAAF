package com.example.tnsfl.BottomNavi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tnsfl.CafeInfo;
import com.example.tnsfl.Adapter.MyAdapter;
import com.example.tnsfl.R;

import me.relex.circleindicator.CircleIndicator3;

public class FragmentPage1 extends Fragment implements View.OnClickListener {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 4;
    private CircleIndicator3 mIndicator;


    LinearLayout widget1,widget2,widget3,widget4,widget5,widget6,widget7,widget8,widget9,widget10,widget11,widget12;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page_1);
    }

    private void setContentView(int fragment_page_1) {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_1, container, false);

        widget1 = (LinearLayout)view.findViewById(R.id.widget_1);
        widget2 = (LinearLayout)view.findViewById(R.id.widget_2);
        widget3 = (LinearLayout)view.findViewById(R.id.widget_3);
        widget4 = (LinearLayout)view.findViewById(R.id.widget_4);
        widget5 = (LinearLayout)view.findViewById(R.id.widget_5);
        widget6 = (LinearLayout)view.findViewById(R.id.widget_6);
        widget7 = (LinearLayout)view.findViewById(R.id.widget_7);
        widget8 = (LinearLayout)view.findViewById(R.id.widget_8);
        widget9 = (LinearLayout)view.findViewById(R.id.widget_9);
        widget10 = (LinearLayout)view.findViewById(R.id.widget_10);
        widget11 = (LinearLayout)view.findViewById(R.id.widget_11);
        widget12 = (LinearLayout)view.findViewById(R.id.widget_12);


        widget1.setOnClickListener(this::onClick);
        widget2.setOnClickListener(this::onClick);
        widget3.setOnClickListener(this::onClick);
        widget4.setOnClickListener(this::onClick);
        widget5.setOnClickListener(this::onClick);
        widget6.setOnClickListener(this::onClick);
        widget7.setOnClickListener(this::onClick);
        widget8.setOnClickListener(this::onClick);
        widget9.setOnClickListener(this::onClick);
        widget10.setOnClickListener(this::onClick);
        widget11.setOnClickListener(this::onClick);
        widget12.setOnClickListener(this::onClick);


        mPager = view.findViewById(R.id.viewpager);
        pagerAdapter = new MyAdapter(getActivity(), num_page);
        mPager.setAdapter(pagerAdapter);
        mIndicator = view.findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(num_page, 0);
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mPager.setCurrentItem(1000); //시작 지점
        mPager.setOffscreenPageLimit(4); //최대 이미지 수
        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }


            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position % num_page);
            }
        });

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setContentView(R.layout.fragment_page_1);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), CafeInfo.class);
        switch (view.getId()){
            case R.id.widget_1:
                intent.putExtra("nameid",1);
                startActivity(intent);
                break;
            case R.id.widget_2:
                intent.putExtra("nameid",2);
                startActivity(intent);
                break;
            case R.id.widget_3:
                intent.putExtra("nameid",3);
                startActivity(intent);
                break;
            case R.id.widget_4:
                intent.putExtra("nameid",4);
                startActivity(intent);
                break;
            case R.id.widget_5:
                intent.putExtra("nameid",5);
                startActivity(intent);
                break;
            case R.id.widget_6:
                intent.putExtra("nameid",6);
                startActivity(intent);
                break;
            case R.id.widget_7:
                intent.putExtra("nameid",7);
                startActivity(intent);
                break;
            case R.id.widget_8:
                intent.putExtra("nameid",8);
                startActivity(intent);
                break;
            case R.id.widget_9:
                intent.putExtra("nameid",9);
                startActivity(intent);
                break;
            case R.id.widget_10:
                intent.putExtra("nameid",10);
                startActivity(intent);
                break;
            case R.id.widget_11:
                intent.putExtra("nameid",11);
                startActivity(intent);
                break;
            case R.id.widget_12:
                intent.putExtra("nameid",12);
                startActivity(intent);
                break;
        }
    }

}
