package com.example.androidui.main.utlis;

import android.util.Log;

public class Logs {
    final static String TAG = "androidui_log";

    public static void d(String msg){
        Log.d(TAG,msg);
    }


    public static void e(String msg){
        Log.e(TAG,msg);
    }
}
