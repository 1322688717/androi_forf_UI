package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityCustomImageViewBinding;


/**
 *自定义imageview
 */

public class CustomImageViewActivity extends AppCompatActivity {

    ActivityCustomImageViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomImageViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    private void initView() {


    }
}