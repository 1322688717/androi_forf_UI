package com.example.androidui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidui.main.business.AddPhotosActivity;
import com.example.androidui.main.business.CompressedImageActivity;
import com.example.androidui.main.business.FileStorageActivity;
import com.example.androidui.main.business.GlideActivity;
import com.example.androidui.main.business.MediaRecorderActivity;
import com.example.androidui.main.business.OkHttpActivity;
import com.example.androidui.main.business.SPActivity;
import com.example.androidui.main.business.TimeStampActivity;
import com.example.androidui.databinding.ActivityBusinessLogicBinding;
import com.example.androidui.main.business.retrofitActivity;

public class BusinessLogicActivity extends AppCompatActivity {

    ActivityBusinessLogicBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBusinessLogicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initview();

    }

    private void initview() {
        binding.btnSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessLogicActivity.this, SPActivity.class);
                startActivity(intent);
            }
        });

        binding.btnTimeStamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessLogicActivity.this, TimeStampActivity.class);
                startActivity(intent);
            }
        });

        binding.btnCompressedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessLogicActivity.this, CompressedImageActivity.class);
                startActivity(intent);
            }
        });

        binding.btnOkhttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessLogicActivity.this, OkHttpActivity.class);
                startActivity(intent);
            }
        });

        binding.btnFileStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusinessLogicActivity.this, FileStorageActivity.class);
                startActivity(intent);
            }
        });

        binding.btnGlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusinessLogicActivity.this, GlideActivity.class);
                startActivity(intent);
            }
        });

        binding.btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusinessLogicActivity.this, retrofitActivity.class);
                startActivity(intent);
            }
        });
        binding.btnMediaRecorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusinessLogicActivity.this, MediaRecorderActivity.class);
                startActivity(intent);
            }
        });

        binding.btnAddPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusinessLogicActivity.this, AddPhotosActivity.class);
                startActivity(intent);
            }
        });
    }
}