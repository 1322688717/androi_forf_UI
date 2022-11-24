package com.example.androidui.main.ui

import android.annotation.SuppressLint
import android.database.Cursor
import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.example.androidui.databinding.ActivityGetMusicBinding
import com.example.androidui.main.base.BaseMvvm
import com.example.androidui.main.bean.BeanImage
import com.example.androidui.main.viewmodle.GetMusicViewModel


class GetMusicActivity : BaseMvvm<GetMusicViewModel,ActivityGetMusicBinding>() {



    override fun initView(savedInstanceState: Bundle?) {
        initImages()
    }


    @SuppressLint("Range")
    private fun initImages() {
        var count = 0

        var imageList : ArrayList<BeanImage> = ArrayList<BeanImage>()
        @SuppressLint("Recycle")  var cursor: Cursor? = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, null, null, null
        )
        while (cursor!!.moveToNext()) {
            //获取图片的名称
            val name: String =
                cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME))
            Log.d("ImgActivity: ", "initImages: imageName: $name")

            //获取图片的路径
            val data: ByteArray =
                cursor.getBlob(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
            val location = String(data, 0, data.size - 1)
            Log.d("ImgActivity: ", "initImages: imageLocation: $location")
            //根据路径获取图片
            //val bm: Bitmap = getImgFromDesc(location)

            //获取图片的详细信息
            val desc: String =
                cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DESCRIPTION))
            Log.d("ImgActivity", "initImages: ImageDesc: $desc")
            //val image = BeanImage(bm, name, location)
            //imageList.add(image)
            count++
            if (count > 3) break
        }
        Log.d("ImgActivity: ", "initImage: " + "imageList.size: " + imageList.size)
    }
}