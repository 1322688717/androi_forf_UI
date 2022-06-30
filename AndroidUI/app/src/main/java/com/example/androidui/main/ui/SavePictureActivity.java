package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivitySavePictureBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class SavePictureActivity extends AppCompatActivity {

    ActivitySavePictureBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySavePictureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnSavePicture.setOnClickListener(view -> btnSavePicture());
    }

    private void btnSavePicture() {


//        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.picture);

//1. 找一个可用的文件位置
        File[] mediaDir = getExternalMediaDirs();
        File output_dir = null;

        if (mediaDir!=null){
            output_dir = mediaDir[0];
        }else {
            output_dir = getApplicationContext().getFilesDir();
        }

        //2. 创建一个空文件
        String file_name=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.CHINA).format(System.currentTimeMillis())+".jpg";
        File f= new File(output_dir,file_name);

//3. 保存图片 （替换成你的图）
        OutputStream os = null;
        try {
            os = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,os);
//4. 让相册扫描这个图片
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.N){
            sendBroadcast(new Intent(Camera.ACTION_NEW_PICTURE, Uri.fromFile(f)));
            Toast.makeText(getApplicationContext(),"我起作用了",Toast.LENGTH_SHORT).show();
        }

        String mimeType = MimeTypeMap.getSingleton()
                .getMimeTypeFromExtension(f.toString());
        MediaScannerConnection.scanFile(getApplicationContext(), new String[]{f.getAbsolutePath()}, new String[]{mimeType}, new MediaScannerConnection.OnScanCompletedListener() {
            @Override
            public void onScanCompleted(String s, Uri uri) {
                Toast.makeText(getApplicationContext(),"已保存",Toast.LENGTH_SHORT).show();

            }
        });


    }

}