package com.example.tnsfl.BottomNavi;

import android.os.Bundle;
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

<<<<<<< HEAD
import com.example.tnsfl.DataModel;
import com.example.tnsfl.MyRecyclerViewAdapter2;
=======
import com.example.tnsfl.DataSet.BoardData;
import com.example.tnsfl.DataSet.Boardexist;
import com.example.tnsfl.Interface.BoardService;
>>>>>>> 88ead84c2611f41b04b0fb052aa69c742aad2ff7
import com.example.tnsfl.R;

<<<<<<< HEAD
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentPage2 extends Fragment {
=======
import java.util.ArrayList;

import VIewpager_2frg.ViewPagerAdapter;

public class FragmentPage2 extends Fragment implements View.OnClickListener {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 4;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<DataModel> dataModelArrayList ;
    private RecyclerView.Adapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page_2);



            }




    private void setContentView(int fragment_page_1) {
    }
>>>>>>> b101fce231bfec718c0c69aa131c2abedf4155b0

    private static final String TAG = "goooooo";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_2, container, false);
<<<<<<< HEAD

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        MyRecyclerViewAdapter2 adpater = new MyRecyclerViewAdapter2(dataModelArrayList, getContext());
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());




=======
<<<<<<< HEAD

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.18:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BoardService service1 = retrofit.create(BoardService.class);

        Call<List<BoardData>> call = service1.getPosts();
        Call<List<Boardexist>> call2 = service1.getThings();

        call.enqueue(new Callback<List<BoardData>>() {
            @Override
            public void onResponse(Call<List<BoardData>> call, Response<List<BoardData>> response) {
                if (response.isSuccessful()) {

                    List<BoardData> result = response.body();
                    Log.d(TAG, "onResponse:성공, 결과 \n" + result.toString());
                } else {

                    Log.d(TAG, "onResponse:실패");
                }
            }

            @Override
            public void onFailure(Call<List<BoardData>> call, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }
        });

        call2.enqueue(new Callback<List<Boardexist>>() {
            @Override
            public void onResponse(Call<List<Boardexist>> call2, Response<List<Boardexist>>response)  {
                if (response.isSuccessful()) {

                    List<Boardexist> result = response.body();
                    Log.d(TAG, "onResponse: 성공, 결과\n" + result.toString());
                } else {

                    Log.d(TAG, "onResponse: 실패");
                }
            }

            @Override
            public void onFailure(Call<List<Boardexist>> call2, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }
        });
=======
>>>>>>> 88ead84c2611f41b04b0fb052aa69c742aad2ff7
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


>>>>>>> b101fce231bfec718c0c69aa131c2abedf4155b0



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
