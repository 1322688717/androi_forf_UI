package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityBannerBinding;
import com.example.androidui.main.adapter.Viewpager2Adapter;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.RectangleIndicator;

import java.util.ArrayList;

public class BannerActivity extends AppCompatActivity {

    ActivityBannerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBannerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    private void initView() {
        ArrayList<Integer> picture = new ArrayList<>();
        picture.add(R.drawable.banner_1);
        picture.add(R.drawable.banner_2);
        picture.add(R.drawable.banner_3);
        picture.add(R.drawable.banner_4);
        picture.add(R.drawable.banner_5);
        picture.add(R.drawable.banner_6);
        picture.add(R.drawable.banner_7);
        picture.add(R.drawable.banner_8);



        binding.viewpager2.setAdapter(new Viewpager2Adapter(picture,BannerActivity.this));





    }


}