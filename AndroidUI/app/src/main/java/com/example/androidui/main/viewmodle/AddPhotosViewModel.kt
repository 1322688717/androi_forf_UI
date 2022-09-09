package com.example.androidui.main.viewmodle

import android.graphics.Picture
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidui.R
import com.example.androidui.main.bean.AddPhotoBean

class AddPhotosViewModel : ViewModel() {

    var listData = MutableLiveData<List<AddPhotoBean>>()


    init {
        val picture = AddPhotoBean("")
        val list  = ArrayList<AddPhotoBean>()
        list.add(picture)
        listData.value = list
    }

    fun setListData(){

    }
}