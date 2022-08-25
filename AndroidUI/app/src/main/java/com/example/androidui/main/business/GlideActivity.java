package com.example.androidui.main.business;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.androidui.databinding.ActivityBusinessLogicBinding;
import com.example.androidui.databinding.ActivityGlideBinding;

public class GlideActivity extends AppCompatActivity {

    private ActivityGlideBinding binding;
    String url = "http://img5.adesk.com/62ab3311e7bce7163c3ae7a7?imageMogr2/thumbnail/!1080x1920r/gravity/Center/crop/1080x1920&sign=faeed199f9956f5efd8d255d730af534&t=6305ad99";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGlideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Glide.with(this)
                .load(url)
                .into(binding.imgPicture);

    }
}