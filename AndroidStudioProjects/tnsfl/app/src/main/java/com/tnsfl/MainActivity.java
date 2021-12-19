package com.tnsfl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tnsfl.BottomNavi.FragmentPage1;
import com.tnsfl.BottomNavi.FragmentPage2;
import com.tnsfl.BottomNavi.FragmentPage3;
import com.tnsfl.BottomNavi.FragmentPage4;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.MessageDigest;

import tnsfl.R;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNV;
    private FragmentStateAdapter pagerAdapter;
    private FragmentPagerAdapter pagerAdapter2;
    private int num_page = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAppKeyHash();

        mBottomNV = findViewById(R.id.nav_view);
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { //NavigationItemSelecte
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigate(menuItem.getItemId());


                return true;

            }

        });
        mBottomNV.setSelectedItemId(R.id.navigation_1);

    }
    private void BottomNavigate(int id) {  //BottomNavigation 페이지 변경
        String tag = String.valueOf(id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            if (id == R.id.navigation_1) {
                fragment = new FragmentPage1();

            } else if (id == R.id.navigation_2){

                fragment = new FragmentPage2();

            }else if (id ==R.id.navigation_3){
                fragment = new FragmentPage3();
            }else{
                fragment = new FragmentPage4();
            }

            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();


    }

    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e("Hash key", something);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("name not found", e.toString());
        }
    }




}



