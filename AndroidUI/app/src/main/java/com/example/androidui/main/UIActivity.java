package com.example.androidui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidui.databinding.ActivityUiactivityBinding;
import com.example.androidui.main.ui.BannerActivity;
import com.example.androidui.main.ui.BarActivity;
import com.example.androidui.main.ui.BottomDialogActivity;
import com.example.androidui.main.ui.ControlLengthActivity;
import com.example.androidui.main.ui.CountdownActivity;
import com.example.androidui.main.ui.DialogActivity;
import com.example.androidui.main.ui.DrawerLayoutActivity;
import com.example.androidui.main.ui.MediaPlayerActivity;
import com.example.androidui.main.ui.NotableActivity;
import com.example.androidui.main.ui.NotableTwoActivity;
import com.example.androidui.main.ui.PermissionActivity;
import com.example.androidui.main.ui.RadioButtonActivity;
import com.example.androidui.main.ui.RcActivity;
import com.example.androidui.main.ui.RefreshActivity;
import com.example.androidui.main.ui.SavePictureActivity;
import com.example.androidui.main.ui.ScrollviewActivity;
import com.example.androidui.main.ui.SearchActivity;
import com.example.androidui.main.ui.ThemesActivity;
import com.example.androidui.main.ui.TimingActivity;
import com.example.androidui.main.ui.TwoRcActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * UI
 */
public class UIActivity extends AppCompatActivity {

    ActivityUiactivityBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUiactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnRadiobutton.setOnClickListener(view -> Radiobutton());
        binding.button5.setOnClickListener(view -> MediaPlayer());
        binding.btnDialog.setOnClickListener(view -> btnDialog());
        binding.btnTiming.setOnClickListener(view ->btnTiming() );
        binding.btnGetTime.setOnClickListener(view -> btnGetTime());
        binding.btnRc.setOnClickListener(view -> btnRc());
        binding.btnScrollView.setOnClickListener(view -> btnScrollView());
        binding.btnCountdown.setOnClickListener(view -> btnCountdown());
        binding.btnEdit.setOnClickListener(view -> btnEdit());
        binding.btnBar.setOnClickListener(view ->btnBar());
        binding.btnThemes.setOnClickListener(view -> btnThemes());
        binding.btnDrawerLayout.setOnClickListener(view -> btnDrawerLayout());
        binding.btnBanner.setOnClickListener(view -> btnBanner());
        binding.btnTwoRc.setOnClickListener(view -> btnTwoRc());
        binding.btnPermission.setOnClickListener(view ->btnPermission() );
        binding.btnSavePicture.setOnClickListener(view -> btnSavePicture());
        binding.btnRefresh.setOnClickListener(view -> btnRefresh());
        binding.btnNotable.setOnClickListener(view ->btnNotable() );
        binding.btnGetLength.setOnClickListener(view -> btnGetLength());
        binding.btnTwoNotable.setOnClickListener(view ->btnTwoNotable() );
        binding.btnBottomDialog.setOnClickListener(View ->btnBottomDialog());
    }

    private void btnTwoNotable() {
        Intent intent = new Intent(UIActivity.this, NotableTwoActivity.class);
        startActivity(intent);
    }

    private void btnGetLength() {
        Intent intent = new Intent(UIActivity.this, ControlLengthActivity.class);
        startActivity(intent);
    }

    private void btnNotable() {
        Intent intent = new Intent(UIActivity.this, NotableActivity.class);
        startActivity(intent);
    }

    private void btnRefresh() {
        Intent intent = new Intent(UIActivity.this, RefreshActivity.class);
        startActivity(intent);
    }

    /**
     * 保存到本地相册
     */
    private void btnSavePicture() {
        Intent intent = new Intent(UIActivity.this, SavePictureActivity.class);
        startActivity(intent);
    }

    /**
     * 获取权限
     */
    private void btnPermission() {
        Intent intent = new Intent(UIActivity.this, PermissionActivity.class);
        startActivity(intent);
    }

    private void btnTwoRc() {
        Intent intent = new Intent(UIActivity.this, TwoRcActivity.class);
        startActivity(intent);
    }

    private void btnBanner() {
        Intent intent = new Intent(UIActivity.this, BannerActivity.class);
        startActivity(intent);
    }

    private void btnDrawerLayout() {
        Intent intent = new Intent(UIActivity.this, DrawerLayoutActivity.class);
        startActivity(intent);
    }

    private void btnThemes() {
        Intent intent = new Intent(UIActivity.this, ThemesActivity.class);
        startActivity(intent);
    }

    private void btnBar() {
        Intent intent = new Intent(UIActivity.this, BarActivity.class);
        startActivity(intent);
    }

    private void btnEdit() {
        Intent intent = new Intent(UIActivity.this, SearchActivity.class);
        startActivity(intent);
    }


    private void btnCountdown() {
        Intent intent = new Intent(UIActivity.this, CountdownActivity.class);
        startActivity(intent);
    }


    private void btnScrollView() {
        Intent intent = new Intent(UIActivity.this, ScrollviewActivity.class);
        startActivity(intent);
    }

    private void btnRc() {
        Intent intent = new Intent(UIActivity.this, RcActivity.class);
        startActivity(intent);
    }

    /**
     * 获取本地时间
     */
    private void btnGetTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        Toast.makeText(UIActivity.this,simpleDateFormat.format(date),Toast.LENGTH_LONG).show();
    }

    private void btnTiming() {
        Intent intent = new Intent(UIActivity.this, TimingActivity.class);
        startActivity(intent);
    }

    /**
     * dialog的使用
     */
    private void btnDialog() {
        Intent intent = new Intent(UIActivity.this, DialogActivity.class);
        startActivity(intent);
    }

    private void MediaPlayer() {
        Intent intent = new Intent(UIActivity.this, MediaPlayerActivity.class);
        startActivity(intent);
    }

    /**
     * Radiobutton的使用
     */
    private void Radiobutton() {
        Intent intent = new Intent(UIActivity.this, RadioButtonActivity.class);
        startActivity(intent);
    }

    private void btnBottomDialog() {
        Intent intent = new Intent(UIActivity.this, BottomDialogActivity.class);
        startActivity(intent);
    }
}