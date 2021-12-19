package com.tnsfl.Adapter;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewDecoration extends RecyclerView.ItemDecoration{

    private final int divWidth;
    private String location;


    public RecyclerViewDecoration(int divWidth , String location)
    {
        this.divWidth = divWidth;
        this.location = location;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);

        if(location == "width"){
            outRect.left = divWidth;
            outRect.right= divWidth;
        }else if(location == "height"){
            outRect.left = divWidth;
            outRect.right= divWidth;
            outRect.bottom=divWidth;
            outRect.top = divWidth;
        }

    }
}