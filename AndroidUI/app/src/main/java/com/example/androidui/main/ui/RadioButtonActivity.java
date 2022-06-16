package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidui.databinding.ActivityRadioButtonBinding;

public class RadioButtonActivity extends AppCompatActivity {

    ActivityRadioButtonBinding binding;
    boolean isclick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRadioButtonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.radioButton3.setOnClickListener(view -> initRadioButton());
    }




    /**
     * 设置radiobutton可以重复点击
     */
    private void initRadioButton() {
        if(isclick){
            binding.radioButton3.setChecked(false);
            isclick=false;
        }else{
            binding.radioButton3.setChecked(true);
            isclick=true;
        }
    }
}