package com.example.androidui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidui.databinding.ActivityMainBinding;
import com.example.androidui.main.AlgorithmActivity;
import com.example.androidui.main.BusinessLogicActivity;
import com.example.androidui.main.DataStructureActivity;
import com.example.androidui.main.UIActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AndroidUI);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnBusinessLogic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BusinessLogicActivity.class);
                startActivity(intent);
            }
        });

        binding.btnUi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UIActivity.class);
                startActivity(intent);
            }
        });

        binding.btnDataStructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataStructureActivity.class);
                startActivity(intent);
            }
        });

        binding.btnAlgorithm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlgorithmActivity.class);
                startActivity(intent);
            }
        });




    }
}