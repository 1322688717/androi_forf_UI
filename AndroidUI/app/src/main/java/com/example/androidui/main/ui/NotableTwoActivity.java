package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityNotableTwoBinding;
import com.example.androidui.main.utlis.Logs;

import java.util.Arrays;

public class NotableTwoActivity extends AppCompatActivity {

    ActivityNotableTwoBinding binding;
    int screemWidth;
    LinearLayout ll;
    ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotableTwoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initSrc();
        initView();
        GetScreen();
    }

    private void initSrc() {
        //binding.srcOne.setlistener
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.srcOne.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i0, int i1, int i2, int i3) {
                    int a1 = binding.a1.getLeft();
                    int b1 = binding.b1.getLeft();
                    int c1 = binding.c1.getLeft();
                    int d1 = binding.d1.getLeft();
                    int f1 = binding.f1.getLeft();
                    int g1 = binding.g1.getLeft();
                    int h1 = binding.h1.getLeft();

//                    Logs.d("a1========"+a1);
//                    Logs.d("i0="+i0);
//                    Logs.d("i1="+i1);
//                    Logs.d("i2="+i2);
//                    Logs.d("i3="+i3);



                    if (binding.a1.getLeft() <= i0 &&  i0<= binding.a5.getLeft()){
                        setwhite();
                        binding.aa.setBackground(getDrawable(R.color.gray));
                       // binding.aa.setImageResource();
                        int[] location = new int[2];
                        binding.aa.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
                        binding.srcTwo.smoothScrollBy(x-(screemWidth/2),y);
                    }
                    if (binding.b1.getLeft() <= i0  && i0 <= binding.b2.getLeft()){
                       // binding.bb.setImageResource(R.color.purple_200);
                        setwhite();
                        binding.bb.setBackground(getDrawable(R.color.gray));
                        int[] location = new int[2];
                        binding.bb.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
                        binding.srcTwo.smoothScrollBy(x-(screemWidth/2),y);
                    }
                    if (binding.c1.getLeft() <= i0 && i0<= binding.c8.getLeft()){
                        setwhite();
                        binding.cc.setBackground(getDrawable(R.color.gray));

                        int[] location = new int[2];
                        binding.cc.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
//                        Logs.e("x==="+x);
//                        Logs.e("screemWidth/2==="+screemWidth/2);
//                        Logs.e("y==="+y);
//                        Logs.e("x-(screemWidth/2)==="+(x-(screemWidth/2)));
                        binding.srcTwo.smoothScrollBy(x-(screemWidth/2),y);

                    }
                    if (binding.d1.getLeft() <= i0  &&  i0 <= binding.d5.getLeft()){
                        setwhite();
                        binding.dd.setBackground(getDrawable(R.color.gray));

                        int[] location = new int[2];
                        binding.dd.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
                        binding.srcTwo.smoothScrollBy(x-(screemWidth/2),y);
                    }
                    if (binding.e1.getLeft() <= i0  &&  i0 <= binding.e5.getLeft()){
                        setwhite();
                        binding.ee.setBackground(getDrawable(R.color.gray));

                        int[] location = new int[2];
                        binding.ee.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
                        binding.srcTwo.smoothScrollBy(x-(screemWidth/2),y);
                    }
                    if (binding.f1.getLeft() <= i0 && i0 <= binding.f5.getLeft()){
                        setwhite();
                        binding.ff.setBackground(getDrawable(R.color.gray));

                        int[] location = new int[2];
                        binding.ff.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
                        binding.srcTwo.smoothScrollBy(x-(screemWidth/2),y);
                    }
                    if (binding.g1.getLeft() <= i0 && i0 <= binding.g2.getLeft()){
                        setwhite();
                        binding.gg.setBackground(getDrawable(R.color.gray));

                        int[] location = new int[2];
                        binding.gg.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
                        binding.srcTwo.smoothScrollBy(x-(screemWidth/2),y);
                    }
                    if (binding.h1.getLeft() <= i0  && i0 <= binding.h1.getRight()){
                        setwhite();
                        binding.hh.setBackground(getDrawable(R.color.gray));

                        int[] location = new int[2];
                        binding.hh.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
                        binding.srcTwo.smoothScrollBy(x-(screemWidth/2),y);
                    }


                }
            });
        }
    }

    private void setwhite() {
        for (ImageView view : Arrays.asList(binding.aa, binding.bb, binding.cc, binding.dd, binding.ee, binding.ff, binding.gg, binding.hh)) {
            view.setBackground(getDrawable(R.color.white));
        }
    }


    private void initView() {
        binding.aa.setOnClickListener(view -> {
            move(view);
            moveTop(binding.a1);
        });
        binding.bb.setOnClickListener(view -> {
            move(view);
            moveTop(binding.b1);
        });
        binding.cc.setOnClickListener(view -> {
            move(view);
            moveTop(binding.c1);
        });
        binding.dd.setOnClickListener(view -> {
            move(view);
            moveTop(binding.d1);
        });
        binding.ee.setOnClickListener(view -> {
            move(view);
            moveTop(binding.e1);
        });
        binding.ff.setOnClickListener(view -> {
            move(view);
            moveTop(binding.f1);
        });
        binding.gg.setOnClickListener(view -> {
            move(view);
            moveTop(binding.g1);
        });
        binding.hh.setOnClickListener(view -> {
            move(view);
            moveTop(binding.h1);
        });
    }



    public void move(View view){

        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        Logs.e("x:"+x+"y:"+y);

        binding.srcTwo.smoothScrollBy(x-(screemWidth/2),y);
    }

    public void moveTop(View view){
        int left = view.getLeft();
        int right = view.getRight();
        binding.srcOne.smoothScrollTo(left,0);
    }

    private void GetScreen() {
        DisplayMetrics metrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getDisplay().getRealMetrics(metrics);
            int widthPixels = metrics.widthPixels;
            int heightPixels = metrics.heightPixels;

            screemWidth = widthPixels;
            Logs.e("手机屏幕宽度为screemWidth====="+screemWidth);
        }else {
            Logs.e("手机sdk小于api30");
        }
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        int screemWidth = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        Logs.e("手机屏幕宽度为screemWidth====="+screemWidth);

    }

}