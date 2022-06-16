package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.androidui.databinding.ActivityTimingBinding;

public class TimingActivity extends AppCompatActivity {

    ActivityTimingBinding binding;
    int i;
    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTimingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnStart.setOnClickListener(view -> btnStart());
        binding.btnReset.setOnClickListener(view -> btnReset());
    }

    private void btnReset() {
        i=0;
        binding.tvTime.setText("0");
    }

    private void btnStart() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String time = String.valueOf(i);
                           binding.tvTime.setText(time);
                        }
                    });
                }
            }
        }).start();
    }
}