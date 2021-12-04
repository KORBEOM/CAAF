package com.example.tnsfl.BottomNavi;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tnsfl.R;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class FragmentPage3 extends Fragment{


    private static final String LOG_TAG = "Fragment3";
    private MapView mapView;
    private ViewGroup mapViewContainer;
    AutoCompleteTextView autoCompleteTextView;

    static final String[] COUNTRIES =new String[]{
            "스타벅스" , "탐앤탐스","스리랑가","스와핑","스콜스"
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_3, container, false);

        autoCompleteTextView = (AutoCompleteTextView)view.findViewById(R.id.auto_search);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.dropdwonlist,COUNTRIES);
        autoCompleteTextView.setAdapter(adapter);

        mapView = new MapView(getActivity());
        mapViewContainer= (ViewGroup) view.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);


        return view;
    }


}
