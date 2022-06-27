package com.example.androidui.main.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.androidui.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Viewpager2Adapter extends RecyclerView.Adapter<Viewpager2Adapter.ViewHold> {

    ArrayList<Integer> bannerlist;
    Activity activity;
    ImageView img_banner;

    public Viewpager2Adapter(ArrayList<Integer> bannerlist, Activity activity) {
        this.bannerlist = bannerlist;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item,parent,false);
        return new Viewpager2Adapter.ViewHold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {
        img_banner.setImageResource(bannerlist.get(position));
    }

    @Override
    public int getItemCount() {
        return bannerlist.size();
    }


    public class ViewHold extends RecyclerView.ViewHolder {
        public ViewHold(@NonNull View itemView) {
            super(itemView);

            img_banner = itemView.findViewById(R.id.img_banner);
        }
    }
}
