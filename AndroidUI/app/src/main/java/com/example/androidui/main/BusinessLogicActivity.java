package com.example.androidui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidui.main.business.CompressedImageActivity;
import com.example.androidui.main.business.SPActivity;
import com.example.androidui.main.business.TimeStampActivity;
import com.example.androidui.databinding.ActivityBusinessLogicBinding;

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
    }
}