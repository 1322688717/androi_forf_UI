package com.example.androidui.main.business;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import com.example.androidui.MainActivity;
import com.example.androidui.R;
import com.example.androidui.databinding.ActivityCompressedImageBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * 压缩图片
 */
public class CompressedImageActivity extends AppCompatActivity {

    ActivityCompressedImageBinding binding;

    public static final int TAKE_PHOTO=1;//声明一个请求码，用于识别返回的结果
    private static final int SCAN_OPEN_PHONE = 2;// 相册
    private Uri imageUri;
    public String path=null;
    Bitmap bitmap;
    public String picpath=null;

    //定义需要的权限列表
    String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCompressedImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            initview();
        }

        askPermission();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initview() {
        binding.btnCamera.setOnClickListener(view -> btnCamera());
        binding.btnPhoto.setOnClickListener(view -> btnPhoto());
        binding.btnOpenPhoto.setOnClickListener(view -> btnOpenPhoto());
    }


    private void btnOpenPhoto() {
    Intent intent = new Intent(Intent.ACTION_PICK,null);
    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
    startActivityForResult(intent,1);
    }

    private void btnPhoto() {
        openGallery();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void btnCamera() {
        openCamera();
    }


    private void askPermission(){

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        },0);

    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //intent.setType("image/*");
        startActivityForResult(intent, SCAN_OPEN_PHONE);

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void openCamera(){
        String imageName = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date());
//        File outputImage=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/data/com.example.woundapplication/"+imageName+".jpg");

        File outputImage = new File(getExternalCacheDir(), imageName+".jpg");

        Objects.requireNonNull(outputImage.getParentFile()).mkdirs();
//        Log.e("", outputImage.getAbsolutePath());
                /*
                创建一个File文件对象，用于存放摄像头拍下的图片，
                把它存放在应用关联缓存目录下，调用getExternalCacheDir()可以得到这个目录，为什么要
                用关联缓存目录呢？由于android6.0开始，读写sd卡列为了危险权限，使用的时候必须要有权限，
                应用关联目录则可以跳过这一步
                 */
        try//判断图片是否存在，存在则删除在创建，不存在则直接创建
        {
            if(outputImage.exists())
            {
                outputImage.delete();
            }
            boolean a = outputImage.createNewFile();
            Log.e("createNewFile", String.valueOf(a));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if(Build.VERSION.SDK_INT>=24)
            //判断安卓的版本是否高于7.0，高于则调用高于的方法，低于则调用低于的方法
            //把文件转换成Uri对象
                    /*
                    因为android7.0以后直接使用本地真实路径是不安全的，会抛出异常。
                    FileProvider是一种特殊的内容提供器，可以对数据进行保护
                     */
        {
            imageUri= FileProvider.getUriForFile(CompressedImageActivity.this,
                    "com.buildmaterialapplication.fileprovider",outputImage);
            //对应Mainfest中的provider
//            imageUri=Uri.fromFile(outputImage);
            path=imageUri.getPath();
            Log.e(">7:",path);
        }
        else {
            imageUri= Uri.fromFile(outputImage);
            path=imageUri.getPath();

            Log.e("<7:",imageUri.getPath());

        }

        //使用隐示的Intent，系统会找到与它对应的活动，即调用摄像头，并把它存储
        Intent intent0=new Intent("android.media.action.IMAGE_CAPTURE");
        intent0.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(intent0,TAKE_PHOTO);
    }
    @SuppressLint("SetTextI18n")
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //ImageView img_result=(ImageView) findViewById(R.id.pic);

        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    //将图片解析成Bitmap对象，并把它显现出来
//                    String filePath = getFilesDir().getAbsolutePath()+"/image.jpeg";
//                    bitmap = BitmapFactory.decodeFile(filePath);
                    //注意bitmap，后面再decode就会为空
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
//                        bitmap = BitmapFactory.decodeFile(picpath);
                    picpath=imageUri.getPath().toString();
                    Log.e("", imageUri.getAuthority());

                    Log.e("picpath",picpath);
                    @SuppressLint("SdCardPath") String fileName = picpath;
                    binding.imgPicture.setImageBitmap(bitmap);
                    binding.imgPicture.invalidate();
                }

                break;
            case SCAN_OPEN_PHONE:
                if (resultCode == RESULT_OK){

                    Uri selectImage=data.getData();
                    String[] FilePathColumn={MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectImage,
                            FilePathColumn, null, null, null);
                    cursor.moveToFirst();
                    //从数据视图中获取已选择图片的路径
                    int columnIndex = cursor.getColumnIndex(FilePathColumn[0]);
                    picpath = cursor.getString(columnIndex);
                    Log.e("picpath",picpath);
                    cursor.close();
                    bitmap = BitmapFactory.decodeFile(picpath);
                    binding.imgPicture.setImageBitmap(bitmap);
                    binding.imgPicture.invalidate();
                }
                break;
            default:
                break;
        }
    }

}
