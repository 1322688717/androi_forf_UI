package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidui.databinding.ActivityThemesBinding;

public class ThemesActivity extends AppCompatActivity {

    ActivityThemesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}