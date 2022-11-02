package com.example.androidui.main.business;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;

import com.example.androidui.databinding.ActivityFileStorageBinding;
import com.example.androidui.main.utlis.Logs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件内部存储
 */

public class FileStorageActivity extends AppCompatActivity {

    ActivityFileStorageBinding binding;
    String filename = "zcq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFileStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initView();
    }


    private void initView() {
        binding.btnStart.setOnClickListener(view -> btnStart());
    }


    /**
     * 开始存储
     */
    private void btnStart() {

        //与应用有关  卸载则丢失
        String filesdir1 = getFilesDir().getPath();
        String filesdir2 = getFilesDir().getAbsolutePath();
        String cacheDir1 = getCacheDir().getPath();
        String CacheDir2 = getCacheDir().getAbsolutePath();

        //存储到sd卡  卸载后不会丢失
        String sdPath1 = Environment.getExternalStorageDirectory().getAbsolutePath();
        String sdPath2 = Environment.getExternalStorageDirectory().getPath();

        Logs.e("filesdir1============="+filesdir1);
        Logs.e("filesdir2============="+filesdir2);
        Logs.e("cacheDir1============="+cacheDir1);
        Logs.e("CacheDir2============="+CacheDir2);
        Logs.e("sdPath1============="+sdPath1);
        Logs.e("sdPath2============="+sdPath2);


        saveContent();
        getContent();

    }

    /**
     * 拿到内容
     */
    private void getContent() {
        try {
            FileInputStream fis = openFileInput(filename);
            try {
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                fis.close();
                binding.tvContent.setText(new String(bytes));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存内容
     */
    private void saveContent() {

        String content = binding.edtContent.getText().toString();
        try {
            FileOutputStream fos = openFileOutput(filename,MODE_PRIVATE);
            try {
                fos.write(content.getBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}