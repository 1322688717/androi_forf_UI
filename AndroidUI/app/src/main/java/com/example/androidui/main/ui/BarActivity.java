package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.androidui.databinding.ActivityBarBinding;
import com.gyf.immersionbar.ImmersionBar;

public class BarActivity extends AppCompatActivity {


    ActivityBarBinding binding;
    boolean type = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnChange.setOnClickListener(view ->btnChange() );

    }

    private void btnChange() {

        if (type){
            ImmersionBar.with(BarActivity.this).statusBarDarkFont(true).init();
            type = false;
        }else {
            ImmersionBar.with(this).statusBarDarkFont(false).init();
            type = true;
        }
    }
}