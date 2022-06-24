package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;

import com.example.androidui.databinding.ActivityDrawerLayoutBinding;

public class DrawerLayoutActivity extends AppCompatActivity {

    ActivityDrawerLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrawerLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnOpen.setOnClickListener(view -> btnStart());
        binding.btnClose.setOnClickListener(view -> btnClose());
    }

    private void btnClose() {
        binding.drawerHome.closeDrawers();
    }

    private void btnStart() {
       binding.drawerHome.openDrawer(Gravity.LEFT);
    }
}