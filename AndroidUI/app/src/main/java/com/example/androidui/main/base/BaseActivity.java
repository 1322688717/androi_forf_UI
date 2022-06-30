package com.example.androidui.main.base;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidui.main.untls.Tips;

public class BaseActivity extends AppCompatActivity {

    public void tip(Object msg){
        Tips.tip(this, msg.toString());
    }
}
