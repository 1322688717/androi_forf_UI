package com.example.androidui.main.business

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidui.databinding.ActivityFileBinding
import com.example.androidui.main.bean.PDFFileInfo
import com.example.androidui.main.utlis.PDFUtil
import java.io.File


@RequiresApi(Build.VERSION_CODES.M)
class FileActivity : AppCompatActivity() {
    lateinit var binding: ActivityFileBinding

    //定义需要的权限列表
    var permissions = arrayOf<String>(
        "android.permission.CAMERA",
        "android.permission.READ_EXTERNAL_STORAGE",
        "android.permission.WRITE_EXTERNAL_STORAGE",
    )

    var cursor: Cursor? = null
    private val pdfData = ArrayList<PDFFileInfo>()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        checkPermissions()

        getFile()

        //  getPhoneNumber()
    }

    private fun checkPermissions() {
        //如果系统大于android6.0，进行动态权限申请
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val i = ContextCompat.checkSelfPermission(this, permissions[0])
            val l = ContextCompat.checkSelfPermission(this, permissions[1])
            val m = ContextCompat.checkSelfPermission(this, permissions[2])
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝，判断需要的权限列表中是否有权限还没拥有
            if (i != PackageManager.PERMISSION_GRANTED || l != PackageManager.PERMISSION_GRANTED || m != PackageManager.PERMISSION_GRANTED) {
                // 如果有权限没有授予，就去提示用户请求
                startRequestPermission()
            }
        }
    }

    private fun startRequestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 321)
    }

    private fun getFile() {
        /**
         * 获取手机文档数据
         *
         * @param
         */

        val columns = arrayOf(
            MediaStore.Files.FileColumns._ID,
            MediaStore.Files.FileColumns.MIME_TYPE,
            MediaStore.Files.FileColumns.SIZE,
            MediaStore.Files.FileColumns.DATE_MODIFIED,
            MediaStore.Files.FileColumns.DATA
        )

        val select = "(_data LIKE '%.pdf')"
        val contentResolver = contentResolver
        val cursor = contentResolver.query(
            MediaStore.Files.getContentUri("external"),
            columns,
            select,
            null,
            null
        )
        var columnIndexOrThrow_DATA = 0
        if (cursor != null) {
            columnIndexOrThrow_DATA =
                cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA)
        }
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val path = cursor.getString(columnIndexOrThrow_DATA)
                val document: PDFFileInfo = PDFUtil.getFileInfoFromFile(File(path))
                pdfData.add(document)
                Log.d(TAG, " pdf $document")
            }
        }
        cursor!!.close()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getPhoneNumber() {

        val columns = arrayOf(
            MediaStore.Files.FileColumns._ID,
            MediaStore.Files.FileColumns.MIME_TYPE,
            MediaStore.Files.FileColumns.SIZE,
            MediaStore.Files.FileColumns.DATE_MODIFIED,
            MediaStore.Files.FileColumns.DATA
        )

        var contentResolver: ContentResolver = contentResolver
        var cursor =
            contentResolver.query(ContactsContract.Contacts.CONTENT_URI, columns, null, null)

        var idIndex = cursor!!.getColumnIndex(columns[0])
        val nameIndex = cursor.getColumnIndex(columns[1])

        if (cursor != null) {
            while (cursor.moveToNext()) {
                val id = cursor.getInt(idIndex)
                val name = cursor.getString(nameIndex)
                Log.e("TAg", "ID=$id  name=$name")
            }
            cursor.close()
        }


    }


}