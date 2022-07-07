package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityControlLengthBinding;
import com.example.androidui.main.base.BaseActivity;

import java.util.HashMap;
import java.util.Map;

public class ControlLengthActivity extends BaseActivity {

    ActivityControlLengthBinding binding;
    Map<String,Integer> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityControlLengthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initview();
    }

    private void initview() {
        binding.btnGet.setOnClickListener(view -> btnGet());
        binding.btnGetScreen.setOnClickListener(view -> btnGetScreen());
    }

    private void btnGetScreen() {
        DisplayMetrics metrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getDisplay().getRealMetrics(metrics);
            int widthPixels = metrics.widthPixels;
            int heightPixels = metrics.heightPixels;
            binding.tvScreenLength.setText("宽度为 ============"+widthPixels+"         高度为=================="+heightPixels);
        }
    }

    private void btnGet() {
        getTextWidthAndHeight(binding.tvOne);
        int height = map.get("height");
        int width = map.get("width");
        binding.tvHeight.setText("高度为："+height);
        binding.tvWidth.setText("宽度为："+width);
    }



    /**
     * 获取控件的宽高
     */
    private Map<String,Integer> getTextWidthAndHeight(TextView textView) {
        int width = textView.getWidth();
        int height = textView.getHeight();
        tip("width:" + width + ", height:" + height);
        map.put("width",width);
        map.put("height",height);
        return map;
    }

}