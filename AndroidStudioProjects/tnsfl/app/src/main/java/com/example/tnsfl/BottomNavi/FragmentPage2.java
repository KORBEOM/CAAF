package com.example.tnsfl.BottomNavi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tnsfl.Adapter.RecyclerViewDecoration;
import com.example.tnsfl.Adapter.marketAdapter;
import com.example.tnsfl.DataSet.BoardData;
import com.example.tnsfl.DataSet.Boardexist;
import com.example.tnsfl.DataSet.kakaResult;
import com.example.tnsfl.DataSet.marketData;
import com.example.tnsfl.Interface.BoardService;
import com.example.tnsfl.Adapter.MyRecyclerViewAdapter2;
import com.example.tnsfl.Interface.kakaoApi;
import com.example.tnsfl.R;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;

import java.util.ArrayList;
import java.util.Collections;
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
    private RecyclerView recyclerView2;
    private RecyclerView.LayoutManager layoutManager;
    private List<BoardData> dataModelArrayList ;
    private List<marketData> MarketdataList = new ArrayList<>();
    MyRecyclerViewAdapter2 adapter;
    AutoCompleteTextView autoCompleteTextView;

    marketData one = new marketData("행복한 분위기를 가짐" , "그리운 느낌은 가짐" , "언제나 웃음이 가득한");
    marketData two = new marketData("우울하고 무서운" , "정겨운 냄새" , "어둠의 자식");


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page_2);

            }


    private void setContentView(int fragment_page_1) {
    }

    private static final String TAG = "gooooooggggggggggggggggggggggggggggggggggggg";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_2, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        MarketdataList.add(one);
        MarketdataList.add(two);

        Log.d(TAG, String.valueOf(MarketdataList.size()));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView2 = view.findViewById(R.id.marketContent);
        Log.d(TAG,"리싸이클러 확인");
        recyclerView2.setHasFixedSize(true);
        marketAdapter Adapter2 = new marketAdapter(MarketdataList,getActivity());
        recyclerView2.addItemDecoration(new RecyclerViewDecoration(30 ,"width"));
        recyclerView2.setAdapter(Adapter2);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        autoCompleteTextView = (AutoCompleteTextView)view.findViewById(R.id.auto_search2);




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

                    List<String> DataSearch = new ArrayList<String>();

                    for(int i = 0 ; i < dataModelArrayList.size(); i++){
                        DataSearch.add(dataModelArrayList.get(i).getTitle());
                        DataSearch.add(dataModelArrayList.get(i).getNickName());
                    }

                    adapter = new MyRecyclerViewAdapter2(dataModelArrayList, getContext());
                    recyclerView.addItemDecoration(new RecyclerViewDecoration(30 , "height"));
                    recyclerView.setAdapter(adapter);
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(),R.layout.dropdwonlist,DataSearch);
                    autoCompleteTextView.setAdapter(adapter1);
                    autoCompleteTextView.setOnItemClickListener(clickListener);

                } else {

                    Log.d(TAG, "onResponse:실패");
                }
            }

            @Override
            public void onFailure(Call<List<BoardData>> call, Throwable t) {
                Log.d(TAG, "onFailure:" + t.getMessage());
            }

            AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String toastMessage = ((TextView)view).getText().toString();
                    searchKeyword(toastMessage);
                    Toast.makeText(getContext(),toastMessage , Toast.LENGTH_SHORT).show();

                }
            };
        });


        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    void searchKeyword(String keyword){

        recyclerView.removeAllViewsInLayout();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-3-35-141-102.ap-northeast-2.compute.amazonaws.com:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        BoardService service = retrofit.create(BoardService.class);

        Call<List<BoardData>> call = service.getBoard(keyword);


        call.enqueue(new Callback<List<BoardData>>() {
            @Override
            public void onResponse(Call<List<BoardData>> call, Response<List<BoardData>> response) {

                if(response.isSuccessful()) {
                    List<BoardData> result = response.body();
                    Log.d(TAG, "onResponse: 성공 , 결과 ," + result );
                    adapter = new MyRecyclerViewAdapter2(result, getContext());
                    recyclerView.setAdapter(adapter);
                }
                else{
                    Log.d(TAG,"onResponse: 실패 " + response.body());
                }
            }



            @Override
            public void onFailure(Call<List<BoardData>> call, Throwable t) {
                Log.d(TAG,"onFailure "+t.getMessage());
            }
        });


    };





}
