package com.example.androidui.main.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ScrollView;

import com.example.androidui.MainActivity;
import com.example.androidui.R;
import com.example.androidui.databinding.ActivityNotableBinding;

public class NotableActivity extends AppCompatActivity {

    ActivityNotableBinding binding;
    private final Handler handler = new Handler();
    int choice = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotableBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnStart.setOnClickListener(view -> btnStart());
        binding.btnStop.setOnClickListener(view ->btnStop() );
        binding.btnRestart.setOnClickListener(view -> btnRestart());
    }

    private void btnRestart() {

        // 弹出跳转设置对话框
        new AlertDialog.Builder(NotableActivity.this)

                .setTitle("跳转设置")
                .setSingleChoiceItems(new String[] { "开头", "结尾" }, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                switch (which) {
                                    case 0:
                                        choice = 0;
                                        break;
                                    case 1:
                                        choice = 1;
                                        break;
                                }
                            }
                        })
                .setPositiveButton("跳转",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                switch (choice) {
                                    case 0:
                                        // 跳转至开头
                                        binding.src
                                                .fullScroll(ScrollView.FOCUS_UP);
                                        break;
                                    case 1:
                                        // 跳转至结尾
                                        binding.src
                                                .fullScroll(ScrollView.FOCUS_DOWN);
                                        break;
                                }
                            }
                        }).setNegativeButton("返回", null).show();
    }

    private void btnStop() {
        handler.removeCallbacks(ScrollRunnable);
    }

    private void btnStart() {
        handler.post(ScrollRunnable);



    }


    private Runnable ScrollRunnable = new Runnable() {
        @Override
        public void run() {
            int off = binding.linear.getMeasuredWidth() - binding.src.getWidth();
            if (off > 0) {
                binding.src.scrollBy(1, 0);
                if (binding.src.getScrollX() == off) {
                    Thread.currentThread().interrupt();
                } else {
                    handler.postDelayed(this, 20);
                }
            }
        }
    };

    /*
     * 跳转按钮监听器
     */
    class btnGotoListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }


}