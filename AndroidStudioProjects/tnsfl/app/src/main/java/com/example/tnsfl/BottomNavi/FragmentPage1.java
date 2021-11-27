package com.example.tnsfl.BottomNavi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tnsfl.MyAdapter;
import com.example.tnsfl.R;

import me.relex.circleindicator.CircleIndicator3;

public class FragmentPage1 extends Fragment implements View.OnClickListener {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 4;
    private CircleIndicator3 mIndicator;
    private ImageView widget_1;
    LinearLayout Cafewidget ;

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
        mPager = view.findViewById(R.id.viewpager);
        pagerAdapter = new MyAdapter(getActivity(), num_page);
        mPager.setAdapter(pagerAdapter);
        mIndicator = view.findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(num_page,0);
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
                mIndicator.animatePageSelected(position%num_page);
            }
        });

        Cafewidget = view.findViewById(R.id.CafeWidget);
        Cafewidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"goooodd",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {

    }


}
