package com.example.androidui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityAlgorithmBinding;

public class AlgorithmActivity extends AppCompatActivity {

    ActivityAlgorithmBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlgorithmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}