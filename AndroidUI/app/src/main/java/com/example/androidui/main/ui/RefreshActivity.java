package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityRefreshBinding;
import com.example.androidui.main.base.BaseActivity;

public class RefreshActivity extends BaseActivity {

    ActivityRefreshBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRefreshBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //initData();
                binding.refresh.setRefreshing(false);
                tip("刷新成功");
            }
        });
    }
}