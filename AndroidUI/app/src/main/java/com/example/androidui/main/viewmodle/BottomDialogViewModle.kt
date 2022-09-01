package com.example.androidui.main.viewmodle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BottomDialogViewModle : ViewModel() {
     var state = MutableLiveData<String>()

    init {
        state.value = "已支付"
    }

    fun setState(state : String){
        this.state.value = state
    }

    fun getState() : LiveData<String>{
        return state
    }
}