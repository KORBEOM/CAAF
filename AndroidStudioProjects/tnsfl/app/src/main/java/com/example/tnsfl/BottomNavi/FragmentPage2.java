package com.example.tnsfl.BottomNavi;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    private Button newBtn;
    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 4;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private RecyclerView.LayoutManager layoutManager;
    private List<BoardData> dataModelArrayList ;
    private List<marketData> MarketdataList = new ArrayList<>();
    MyRecyclerViewAdapter2 adapter;
    private InputMethodManager imm;
    Dialog custom_dialog;
    AutoCompleteTextView autoCompleteTextView;
    Dialog newDial;

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ec2-3-35-141-102.ap-northeast-2.compute.amazonaws.com:9000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    BoardService service1 = retrofit.create(BoardService.class);


    marketData one = new marketData("없는 것 빼고 다 있는 VR카페" , "친구들과 내기 한판" , "넓은 공간 리얼감 UP");
    marketData two = new marketData("반려동물과의 편한 쉼터 공간" , "반려동물을 안키워도 입장 가능" , "강아지들의 사회정 키워주기");
    marketData three = new marketData("조용한 분위기","혼자 사용 가능한 개인실","간식 제공");


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

        imm = (InputMethodManager) getContext().getSystemService(getContext().INPUT_METHOD_SERVICE);

        newBtn = (Button) view.findViewById(R.id.button_frg2);
        newDial = new Dialog(getActivity());
        newDial.requestWindowFeature(Window.FEATURE_NO_TITLE);
        newDial.setContentView(R.layout.custom_dialog);

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcustomDialog();
            }
        });

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        MarketdataList.add(one);
        MarketdataList.add(two);
        MarketdataList.add(three);

        Log.d(TAG, String.valueOf(MarketdataList.size()));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView2 = view.findViewById(R.id.marketContent);
        recyclerView2.setHasFixedSize(true);
        marketAdapter Adapter2 = new marketAdapter(MarketdataList,getActivity());
        recyclerView2.addItemDecoration(new RecyclerViewDecoration(30 ,"width"));
        recyclerView2.setAdapter(Adapter2);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);

        recyclerView2.setLayoutManager(layoutManager2);


        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        autoCompleteTextView = (AutoCompleteTextView)view.findViewById(R.id.auto_search2);

        responeBoard();

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    void searchKeyword(String keyword){

        recyclerView.removeAllViewsInLayout();


        Call<List<BoardData>> call = service1.getBoard(keyword);

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
    public void showcustomDialog(){
        newDial.show();

        String[] items = {"자유게시판" , "추천게시판" };

        EditText title = (EditText)newDial.findViewById(R.id.titleDial);
        Spinner categorie = (Spinner)newDial.findViewById(R.id.categoriemenu);
        TextView cateName = (TextView)newDial.findViewById(R.id.cate);
        EditText content = (EditText)newDial.findViewById(R.id.contentDial) ;

        ArrayAdapter<String> adapterSpin = new ArrayAdapter<String>(getContext(), R.layout.dropdwonlist,items);
        adapterSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorie.setAdapter(adapterSpin);

        categorie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cateName.setText(items[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                cateName.setText(null);
            }
        });

        Button btnAdd = newDial.findViewById(R.id.addBtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(title.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getContext(), "글을 입력해주세요!!!", Toast.LENGTH_LONG).show();
                }else if(content.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getContext(), "글을 입력해주세요!!!", Toast.LENGTH_LONG).show();
                }
                else{
                    String userId = "익명" ;

                    recyclerView.removeAllViewsInLayout();
                    Call<String> call = service1.setBoard(title.getText().toString(),cateName.getText().toString(),userId,content.getText().toString());

                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if(response.isSuccessful()){
                                String result = response.body();
                                Log.d(TAG,result);
                                Call<List<BoardData>> call1 = service1.getPosts();

                                call1.enqueue(new Callback<List<BoardData>>() {
                                    @Override
                                    public void onResponse(Call<List<BoardData>> call, Response<List<BoardData>> response) {
                                        if(response.isSuccessful()){
                                            List<BoardData> result2 = response.body();
                                            Log.d(TAG , "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                                            adapter = new MyRecyclerViewAdapter2(result2, getContext());
                                            recyclerView.setAdapter(adapter);
                                            title.setText(null);
                                            content.setText(null);
                                            cateName.setText(null);
                                            newDial.dismiss();
                                        }else{
                                            Log.d(TAG,"onResponse: 실패 " + response.body());
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<List<BoardData>> call, Throwable t) {
                                        Log.d(TAG,"onFailure "+t.getMessage());
                                    }
                                });
                            }else{
                                Log.d(TAG,"onResponse: 실패 " + response.body());
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d(TAG,"onFailure aaaaaaaaaaaaaaaaaaaaaa"+t.getMessage());
                        }
                    });
                }

            }
        });
        Button btnCancle1 = newDial.findViewById(R.id.cancelBtn);
        btnCancle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                title.setText(null);
                content.setText(null);
                cateName.setText(null);
                newDial.dismiss(); // 다이얼로그 닫기
            }
        });
    }

    public void responeBoard(){
        Call<List<BoardData>> call = service1.getPosts();

        call.enqueue(new Callback<List<BoardData>>() {
            @Override
            public void onResponse(Call<List<BoardData>> call, Response<List<BoardData>> response) {
                if (response.isSuccessful()) {

                    dataModelArrayList = response.body();
                    Log.d(TAG, "onResponse:성공, 결과 \n" + dataModelArrayList);

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
                    hideKeyboard(autoCompleteTextView);
                    String toastMessage = ((TextView)view).getText().toString();
                    searchKeyword(toastMessage);
                    Toast.makeText(getContext(),toastMessage , Toast.LENGTH_SHORT).show();
                }
            };
        });
    }

    public final void hideKeyboard(View v){
        InputMethodManager var10000 = this.imm;
        if(var10000 != null){
            var10000.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }


}
