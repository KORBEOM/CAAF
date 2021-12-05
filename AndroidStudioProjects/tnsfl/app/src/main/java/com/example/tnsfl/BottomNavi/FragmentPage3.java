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

import com.example.tnsfl.DataSet.kakaResult;
import com.example.tnsfl.Interface.kakaoApi;
import com.example.tnsfl.R;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentPage3 extends Fragment{

    private final String API_KEY = "KakaoAK e3ed986bb1fc57e3a43528fecbf5600d";

    private static final String LOG_TAG = "Fragment3";
    private MapView mapView;
    private ViewGroup mapViewContainer;
    AutoCompleteTextView autoCompleteTextView;

    static final String[] COUNTRIES =new String[]{
            "스타벅스" , "탐앤탐스"
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_3, container, false);

        autoCompleteTextView = (AutoCompleteTextView)view.findViewById(R.id.auto_search);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.dropdwonlist,COUNTRIES);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(clickListener);

        mapView = new MapView(getActivity());
        mapViewContainer= (ViewGroup) view.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);


        return view;
    }

    AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String toastMessage = ((TextView)view).getText().toString();
            searchKeyword(toastMessage);
            Toast.makeText(getContext(),toastMessage , Toast.LENGTH_SHORT).show();
        }
    };


    void searchKeyword(String keyword){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        kakaoApi service = retrofit.create(kakaoApi.class);

        Call<kakaResult> call = service.getSearch(API_KEY,"스");

        call.enqueue(new Callback<kakaResult>() {
            @Override
            public void onResponse(Call<kakaResult> call, Response<kakaResult> response) {
                if(response.isSuccessful()){
                    kakaResult result =response.body();
                    Log.d(LOG_TAG,"onResponse: 성공 , 결과 ," + result.getDocuments().get(1).getAddress_name() );
                }
                else{
                    Log.d(LOG_TAG,"onResponse: 실패 " + response.body());
                }
            }

            @Override
            public void onFailure(Call<kakaResult> call, Throwable t) {
                Log.d(LOG_TAG,"onFailure "+t.getMessage());

            }
        });


    };

}
