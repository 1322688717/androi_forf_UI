package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityMediaPlayerBinding;

public class MediaPlayerActivity extends AppCompatActivity {

    ActivityMediaPlayerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMediaPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}