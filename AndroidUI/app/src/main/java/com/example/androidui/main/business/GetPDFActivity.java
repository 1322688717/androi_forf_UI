package com.example.androidui.main.business;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.example.androidui.R;
import com.example.androidui.main.bean.PDFFileInfo;
import com.example.androidui.main.utlis.PDFUtil;

import java.io.File;
import java.util.ArrayList;

public class GetPDFActivity extends AppCompatActivity {

    private ArrayList<PDFFileInfo> pdfData = new ArrayList<>();

    ArrayList<String> permissions =  new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pdfactivity);


        permissions.add( "android.permission.CAMERA");
        permissions.add( "android.permission.READ_EXTERNAL_STORAGE");
        permissions.add(  "android.permission.WRITE_EXTERNAL_STORAGE");

        checkPermissions();

        getDocumentData();
    }


    /**
     * 获取手机文档数据
     *
     * @param
     */
    public void getDocumentData() {

        String[] columns = new String[]{MediaStore.Files.FileColumns._ID, MediaStore.Files.FileColumns.MIME_TYPE, MediaStore.Files.FileColumns.SIZE, MediaStore.Files.FileColumns.DATE_MODIFIED, MediaStore.Files.FileColumns.DATA};

        String select = "(_data LIKE '%.pdf')";

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Files.getContentUri("external"), columns, select, null, null);

        int columnIndexOrThrow_DATA = 0;
        if (cursor != null) {
            columnIndexOrThrow_DATA = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
        }

        if (cursor != null) {
            while (cursor.moveToNext()) {

                String path = cursor.getString(columnIndexOrThrow_DATA);

                PDFFileInfo document = PDFUtil.getFileInfoFromFile(new File(path));

                pdfData.add(document);
                Log.d("TAG", " pdf " + document);
            }
            cursor.close();
        }


    }
    /**
     * 申请权限
     */
    private void checkPermissions() {
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


}