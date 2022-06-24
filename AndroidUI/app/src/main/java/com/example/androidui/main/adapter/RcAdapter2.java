package com.example.androidui.main.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidui.R;

import java.util.ArrayList;
import java.util.List;

public class RcAdapter2 extends RecyclerView.Adapter<RcAdapter2.ViewHolder> {

    Activity activity;
    List list;
    ImageView img_picture;

    public RcAdapter2(Activity activity, List list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler2_item,parent,false);
        return new RcAdapter2.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        img_picture.setBackground((Drawable) list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

             img_picture = itemView.findViewById(R.id.img_picture);
        }
    }
}
