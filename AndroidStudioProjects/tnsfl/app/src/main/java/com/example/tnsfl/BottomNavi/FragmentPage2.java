package com.example.tnsfl.BottomNavi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tnsfl.DataSet.BoardData;
import com.example.tnsfl.DataSet.Boardexist;
import com.example.tnsfl.Interface.BoardService;
import com.example.tnsfl.Adapter.MyRecyclerViewAdapter2;
import com.example.tnsfl.R;

import java.util.List;

import VIewpager_2frg.ViewPagerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class FragmentPage2 extends Fragment  {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 4;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<BoardData> dataModelArrayList ;
    private RecyclerView.Adapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page_2);



            }




    private void setContentView(int fragment_page_1) {
    }

    private static final String TAG = "goooooo";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_2, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-3-35-141-102.ap-northeast-2.compute.amazonaws.com:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BoardService service1 = retrofit.create(BoardService.class);

        Call<List<BoardData>> call = service1.getPosts();
        Call<List<Boardexist>> call2 = service1.getThings();

        call.enqueue(new Callback<List<BoardData>>() {
            @Override
            public void onResponse(Call<List<BoardData>> call, Response<List<BoardData>> response) {
                if (response.isSuccessful()) {

                    dataModelArrayList = response.body();
                    Log.d(TAG, "onResponse:성공, 결과 \n" + dataModelArrayList.get(0));

                    MyRecyclerViewAdapter2 adapter = new MyRecyclerViewAdapter2(dataModelArrayList, getContext());
                    recyclerView.setAdapter(adapter);
                } else {

                    Log.d(TAG, "onResponse:실패");
                }
            }

            @Override
            public void onFailure(Call<List<BoardData>> call, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }
        });



        mPager = view.findViewById(R.id.viewpager22);
        pagerAdapter = new ViewPagerAdapter(getActivity(),num_page);
        mPager.setAdapter(pagerAdapter);
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


        });





        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



}
