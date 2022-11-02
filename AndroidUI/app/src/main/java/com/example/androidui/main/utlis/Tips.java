package com.example.androidui.main.utlis;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class Tips {
    static public void tip(final Activity context, String msg ){
        //context.runOnUiThread(() -> Toast.makeText(context, msg, Toast.LENGTH_SHORT).show());
        context.runOnUiThread(()->showToast(context,msg));
    }

    static public void tip(final Activity context, int stringId){
        Tips.tip(context, context.getResources().getString(stringId));
    }

    /**
     * 解决Toast重复显示的问题
     */
    private static Toast mToast;
    public static void showToast(Context context, String text) {
        if(mToast == null) {
            mToast = Toast.makeText(context, text,Toast.LENGTH_LONG);
        } else {
            mToast.cancel();
            mToast = Toast.makeText(context, text,Toast.LENGTH_LONG);
        }
        mToast.setGravity(Gravity.CENTER,0,0);
        mToast.show();
    }
}
