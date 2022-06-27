package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityTwoRcBinding;
import com.example.androidui.main.adapter.EditorAdapter;
import com.example.androidui.main.adapter.EditorTitleAdapter;

import java.util.ArrayList;
import java.util.List;

public class TwoRcActivity extends AppCompatActivity {

    ActivityTwoRcBinding binding;
    ArrayList<Integer> list_bottom = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTwoRcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initDate();

        initRcStyle();

        initRcTitle();
    }

    private void initRcTitle() {

    }

    private void initDate() {
        list_bottom.add((R.drawable.age));
        list_bottom.add((R.drawable.gender));
        list_bottom.add((R.drawable.style));
        list_bottom.add((R.drawable.skin_care));
        list_bottom.add((R.drawable.filter));
        list_bottom.add((R.drawable.lip_color));
        list_bottom.add((R.drawable.whimsy));
        list_bottom.add((R.drawable.cartoon));


    }

    private void initRcStyle() {
        binding.rcStyle.setLayoutManager(new LinearLayoutManager(TwoRcActivity.this,LinearLayoutManager.HORIZONTAL,false));
        EditorAdapter editorAdapter = new EditorAdapter(list_bottom,TwoRcActivity.this,binding.rcTitle);
        binding.rcStyle.setAdapter(editorAdapter);
    }
}