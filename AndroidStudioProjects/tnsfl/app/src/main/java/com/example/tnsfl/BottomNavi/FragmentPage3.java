package com.example.tnsfl.BottomNavi;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import net.daum.mf.map.api.MapView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tnsfl.R;

public class FragmentPage3 extends Fragment {

    private static final String LOG_TAG = "Fragment3";
    private static final int RESULT_OK = 1;
    private MapView mapView;
    private ViewGroup mapViewContainer;
    private static final String TAG = "gggggggggggggggggggggggggg";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_page_3, container, false);
        onStart();

        MapView mapView = new MapView(getActivity());
        RelativeLayout Container = (RelativeLayout) view.findViewById(R.id.map_view);
        Container.addView(mapView);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}

