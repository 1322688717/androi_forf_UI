package com.example.androidui.main.business;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.androidui.databinding.ActivitySpactivityBinding;

public class SPActivity extends AppCompatActivity {

    ActivitySpactivityBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSave.setOnClickListener(view -> btnSave());
        binding.btnGet.setOnClickListener(view -> btnGet());
    }

    private void btnGet() {
        SharedPreferences sharedPreferences=getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String val =  sharedPreferences.getString("name","");
        binding.tvVal.setText(val);
    }

    private void btnSave() {
        //sp为新建xml文件的文件名，MODE模式，PRIVATE私有
        SharedPreferences sharedPreferences=getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name","张三");
        editor.commit();
    }
}