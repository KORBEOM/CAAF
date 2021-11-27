package VIewpager_2frg;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;



public class ViewPagerAdapter extends FragmentStateAdapter {

    public int mCount;
    public ViewPagerAdapter(@NonNull FragmentActivity fm , int count) {
        super(fm);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        switch (index){
            case 0:
            {
                return new Fragment2_slide1();
            }
            case 1:
            {
                return new Fragment2_slide2();
            }
            case 2:
            {
                return new Fragment2_slide3();
            }
            default:
                return new Fragment2_slide1();
        }
    }

    @Override
    public int getItemCount() {
        return 2000;
    }


    public int getRealPosition(int position) { return position % mCount; }



}
