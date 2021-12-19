package com.tnsfl.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tnsfl.DataSet.marketData;
import tnsfl.R;

import java.util.List;

public class marketAdapter extends RecyclerView.Adapter<marketAdapter.ViewHolder> {

    private List<marketData> items;
    private static final String TAG = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
    private Activity activity;

    public marketAdapter( List<marketData> items , Activity activity){
        this.items = items;
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

        holder.image.setImageBitmap(item.getImage());
        holder.tag_one.setText(item.getTag1());
        holder.tag_two.setText(item.getTag2());
        holder.tag_three.setText(item.getTag3());
    }



    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView tag_one;
        TextView tag_two;
        TextView tag_three;

        public ViewHolder(View itemView){
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.market);
            tag_one = (TextView) itemView.findViewById(R.id.squareMeter_text1);
            tag_two = (TextView) itemView.findViewById(R.id.squareMeter_text2);
            tag_three = (TextView) itemView.findViewById(R.id.squareMeter_text3);
        }

    }
}
