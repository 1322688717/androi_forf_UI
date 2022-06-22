package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.androidui.databinding.ActivityCountdownBinding;
import com.example.androidui.main.UIActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownActivity extends AppCompatActivity {

    ActivityCountdownBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountdownBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnStart.setOnClickListener(view -> btnStart());
        initview();
    }

    private void initview() {
        SharedPreferences sharedPreferences=getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        Long endtime =sharedPreferences.getLong("endtime",1);
        if (endtime>System.currentTimeMillis()){
            binding.btnStart.setClickable(false);
            new CountDownTimer(endtime-System.currentTimeMillis(), 1000) {
                public void onTick(long millisUntilFinished) {
                    String time = timeConversion((int) millisUntilFinished/1000);
                    binding.tvTime.setText(time);
                }
                public void onFinish() {
                    binding.tvTime.setText("done!");
                }
            }.start();
        }else {
            binding.tvTime.setText("done!");
            binding.btnStart.setClickable(true);
        }

    }

    private void btnStart() {
        Long currentime = System.currentTimeMillis();
        Long endtime = currentime+(30*60*1000);
        SharedPreferences sharedPreferences=getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putLong("endtime",endtime);
        editor.commit();
        Log.e("TAG", "currentime=========="+currentime);
        Log.e("TAG", "endtime=========="+endtime);
        long counttime = endtime-currentime;
        Log.e("TAG", "counttime=========="+counttime);

        new CountDownTimer(counttime, 1000) {
            public void onTick(long millisUntilFinished) {
                String time = timeConversion((int) millisUntilFinished/1000);
                binding.tvTime.setText(time);
            }
            public void onFinish() {
                binding.tvTime.setText("done!");
            }
        }.start();

    }



    public String timeConversion(int time) {
        int hour = 0;
        int minutes = 0;
        int sencond = 0;
        int temp = time % 3600;
        if (time > 3600) {
            hour = time / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    minutes = temp / 60;
                    if (temp % 60 != 0) {
                        sencond = temp % 60;
                    }
                } else {
                    sencond = temp;
                }
            }
        } else {
            minutes = time / 60;
            if (time % 60 != 0) {
                sencond = time % 60;
            }
        }
        return (minutes<10?("0"+minutes):minutes) + ":" + (sencond<10?("0"+sencond):sencond);
    }
}