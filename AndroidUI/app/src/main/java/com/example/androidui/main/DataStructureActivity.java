package com.example.androidui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityDataStructureBinding;

public class DataStructureActivity extends AppCompatActivity {

    ActivityDataStructureBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataStructureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intitView();
    }


    private void intitView() {
        binding.btnMindMapping.setOnClickListener(view ->btnMindMapping() );
        binding.btnArray.setOnClickListener(view ->btnArray() );
    }

    private void btnArray() {
        binding.tvContent.setText("数组中的数据元素可以是基本数据类型，也可以是引用数据类型；\n" +
                "\n" +
                "数组具有下标，下标从0开始计数，用于快速获取数组中的数据，比如a[0]，表示数组中的第一个数据；\n" +
                "\n" +
                "数组在创建的时候，需要在内存中申请一段固定长度的内存，如果申请的长度超过内存剩余的长度，则容易产生碎片，导致存储失败；\n" +
                "\n" +
                "数组便于查找和修改数据，不便于增删数据；\n" +
                "\n" +
                "数组分为数值数组，字符数组，指针数组，结构数组等；\n");
    }

    private void btnMindMapping() {

    }
}