package com.example.androidui.main.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidui.R;

import java.util.ArrayList;

public class ViewPager2NavigationAdapter extends RecyclerView.Adapter<ViewPager2NavigationAdapter.ViewHold>{

    ArrayList<Fragment> fragmentList;
    Activity activity;
    View view;

    public ViewPager2NavigationAdapter(ArrayList<Fragment> fragmentList, Activity activity) {
        this.fragmentList = fragmentList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewPager2NavigationAdapter.ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new ViewPager2NavigationAdapter.ViewHold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPager2NavigationAdapter.ViewHold holder, int position) {
      //  view = fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return  fragmentList.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {
        public ViewHold(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.item_fragment);
        }
    }
}
