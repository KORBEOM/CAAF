package com.example.tnsfl.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tnsfl.CafeDetail;
import com.example.tnsfl.DataSet.CafeItem;
import com.example.tnsfl.DataSet.marketData;
import com.example.tnsfl.R;

import java.util.List;

public class marketAdapter extends RecyclerView.Adapter<marketAdapter.ViewHolder> {

    private List<marketData> items;
    private static final String TAG = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
    private Activity activity;

    public marketAdapter( List<marketData> items , Activity activity){
        this.items = items;
        Log.d(TAG, String.valueOf(items.get(0).getTag1()));
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cafepromote,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(marketAdapter.ViewHolder holder, int position) {
        marketData item = items.get(position);

        holder.tag_one.setText(item.getTag1());
        holder.tag_two.setText(item.getTag2());
        holder.tag_three.setText(item.getTag3());
    }



    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tag_one;
        TextView tag_two;
        TextView tag_three;

        public ViewHolder(View itemView){
            super(itemView);

            tag_one = (TextView) itemView.findViewById(R.id.squareMeter_text1);
            tag_two = (TextView) itemView.findViewById(R.id.squareMeter_text2);
            tag_three = (TextView) itemView.findViewById(R.id.squareMeter_text3);
        }

    }
}
