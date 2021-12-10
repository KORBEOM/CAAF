package com.example.tnsfl.Adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
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

import java.util.List;

public class CafeRecyclerAdapter extends RecyclerView.Adapter<CafeRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<CafeItem> items;
    private static final String TAG = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
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
        Log.d(TAG,item.getTitle());
        holder.image.setImageBitmap(item.getImage());
        holder.title.setText(item.getTitle());
        holder.content.setText(item.getPhone());
        holder.comment.setText(item.getCategorie());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,item.getTitle());
                Toast.makeText(view.getContext(), item.getTitle(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,CafeDetail.class);
                intent.putExtra("categorie" , item.getCategorie());
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
        TextView content;
        TextView comment;
        CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.cafe_logo);
            title = (TextView)itemView.findViewById(R.id.cafe_title);
            content = (TextView)itemView.findViewById(R.id.cafe_content);
            comment = (TextView) itemView.findViewById(R.id.cafe_comment);
            cardView = (CardView) itemView.findViewById(R.id.cafe_total);
        }

    }
}
