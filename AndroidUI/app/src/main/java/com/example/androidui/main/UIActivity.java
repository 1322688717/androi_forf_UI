package com.example.androidui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidui.databinding.ActivityUiactivityBinding;
import com.example.androidui.main.ui.DialogActivity;
import com.example.androidui.main.ui.MediaPlayerActivity;
import com.example.androidui.main.ui.RadioButtonActivity;
import com.example.androidui.main.ui.TimingActivity;

public class UIActivity extends AppCompatActivity {

    ActivityUiactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUiactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnRadiobutton.setOnClickListener(view -> Radiobutton());
        binding.button5.setOnClickListener(view -> MediaPlayer());
        binding.btnDialog.setOnClickListener(view -> btnDialog());
        binding.btnTiming.setOnClickListener(view ->btnTiming() );
    }

    private void btnTiming() {
        Intent intent = new Intent(UIActivity.this, TimingActivity.class);
        startActivity(intent);
    }

    /**
     * dialog的使用
     */
    private void btnDialog() {
        Intent intent = new Intent(UIActivity.this, DialogActivity.class);
        startActivity(intent);
    }

    private void MediaPlayer() {
        Intent intent = new Intent(UIActivity.this, MediaPlayerActivity.class);
        startActivity(intent);
    }

    /**
     * Radiobutton的使用
     */
    private void Radiobutton() {
        Intent intent = new Intent(UIActivity.this, RadioButtonActivity.class);
        startActivity(intent);
    }
}