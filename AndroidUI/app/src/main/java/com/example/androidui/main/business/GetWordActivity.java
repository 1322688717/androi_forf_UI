package com.example.androidui.main.business;

import static com.example.androidui.main.utlis.FileToBase64Utli.fileToBase64;
import static com.example.androidui.main.utlis.PDFUtil.getMIMEType;
import static com.example.androidui.main.utlis.UriToFileUtli.getPathByUri4kitkat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityGetWordBinding;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class GetWordActivity extends AppCompatActivity {

    private ActivityGetWordBinding binding;
    ArrayList<String> permissions =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetWordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GetRequestPermiss();
        initView();

    }

    private void initView() {
        binding.btnGetWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        selectImage();
                    }
                }).start();

            }
        });
    }

    /**
     * 获取权限
     */
    private void GetRequestPermiss() {
        permissions.add( "android.permission.CAMERA");
        permissions.add( "android.permission.READ_EXTERNAL_STORAGE");
        permissions.add(  "android.permission.WRITE_EXTERNAL_STORAGE");

        //如果系统大于android6.0，进行动态权限申请
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int i = ContextCompat.checkSelfPermission(this, permissions.get(0));
            int l = ContextCompat.checkSelfPermission(this, permissions.get(1));
            int m = ContextCompat.checkSelfPermission(this, permissions.get(2));
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝，判断需要的权限列表中是否有权限还没拥有
            if (i != PackageManager.PERMISSION_GRANTED || l != PackageManager.PERMISSION_GRANTED || m != PackageManager.PERMISSION_GRANTED) {
                // 如果有权限没有授予，就去提示用户请求
                startRequestPermission();
            }
        }
    }

    /**
     * 通过权限列表，提示用户赋予或禁止当前还未拥有的权限
     */
    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this, permissions.toArray(new String[permissions.size()]),321);
    }

    static final int REQUEST_IMAGE_OPEN = 1;

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[] {
                "image/jpeg", // .pdf
                "application/vnd.oasis.opendocument.text", // .odt
                "text/plain" // .txt
        });
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_OPEN && resultCode == RESULT_OK) {
            Uri fullPhotoUri = data.getData();
            // Do work with full size photo saved at fullPhotoUri
            Log.e("TAG","requestCode=="+requestCode);
            Log.e("TAG","resultCode=="+resultCode);
            Log.e("TAG","data=="+data);
            Log.e("TAG","fullPhotoUri=="+fullPhotoUri);
            String v_path  = getPathByUri4kitkat(GetWordActivity.this,fullPhotoUri);
            Log.e("TAG","v_path=="+v_path);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    onResult(v_path);
                }
            }).start();
        }
    }

    public void onResult(String path ) {
        if (path == null)
            return;
        File file = new File(path);
        String base64 = fileToBase64(file);
        Log.e("TAG", "base64==" + base64);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                binding.tvBase64.setText(base64);
            }
        });

    }



}