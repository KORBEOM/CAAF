package com.example.tnsfl.Adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tnsfl.CafeDetail;
import com.example.tnsfl.DataSet.CafeItem;
import com.example.tnsfl.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Base64;
import java.util.List;

public class CafeRecyclerAdapter extends RecyclerView.Adapter<CafeRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<CafeItem> items;
    private static final String TAG = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private Activity activity;

    public CafeRecyclerAdapter(Context context, List<CafeItem> items , Activity activity){
        this.context = context;
        this.items = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cafe_itemview,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CafeItem item = items.get(position);


        if(item.getImage() != null){
            String imageString = item.getImage();
            Bitmap decodeByte = BitmapFactory.decodeByteArray(Base64.getDecoder().decode(imageString),0,Base64.getDecoder().decode(imageString).length );
            holder.image.setImageBitmap(decodeByte);
        }
        holder.title.setText(item.getTitle());
        holder.phone.setText(item.getPhone());
        holder.newaddress.setText(item.getLocation2());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), item.getTitle(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,CafeDetail.class);
                intent.putExtra("cafeName" , item.getTitle());
                activity.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;
        TextView phone;
        CardView cardView;
        TextView newaddress;

        public ViewHolder(View itemView){
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.cafe_logo);
            title = (TextView)itemView.findViewById(R.id.cafe_title);
            phone = (TextView) itemView.findViewById(R.id.cafe_phone);
            newaddress = (TextView)itemView.findViewById(R.id.newaddress);
            cardView = (CardView) itemView.findViewById(R.id.cafe_total);
        }

    }

}
