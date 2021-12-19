package com.tnsfl.Adapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tnsfl.VIewpager_1frg.Fragment_slide1;
import com.tnsfl.VIewpager_1frg.Fragment_slide2;
import com.tnsfl.VIewpager_1frg.Fragment_slide3;

public class MyAdapter extends FragmentStateAdapter {

    public int mCount;

    public MyAdapter(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        switch (index){
            case 0:
            {
                return new Fragment_slide1();
            }
            case 1:
            {
                return new Fragment_slide2();
            }
            case 2:
            {
                return new Fragment_slide3();
            }
            default:
                return new Fragment_slide3();
        }
    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) { return position % mCount; }

}