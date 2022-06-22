package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.androidui.databinding.ActivityScrollviewBinding;

public class ScrollviewActivity extends AppCompatActivity {

    ActivityScrollviewBinding binding;
    String contract = "翟超群";
    Handler handler = new Handler(Looper.getMainLooper());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScrollviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getContrct();   //设置文本内容
        //initScr();  //设置scrollview
    }



    @SuppressLint("ClickableViewAccessibility")
    private void initScr() {
        binding.scrView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (binding.scrView.getScrollY()<=0){
                            Log.i("Main","滑动到顶部");
                        }
                        if (binding.scrView.getChildAt(0).getMeasuredHeight()<=binding.scrView.getHeight()+binding.scrView.getScrollY()){
                            Log.i("Main","滑动到底部");
                        }
                        break;
                }
                return false;
            }
        });
    }

    private void setText() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                binding.tvContract.setText(contract);
            }
        });
    }

    private void getContrct() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (true){
                    contract = contract+"翟超群"+i;
                    i++;
                    binding.scrView.fullScroll(ScrollView.FOCUS_DOWN);
                    setText();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}