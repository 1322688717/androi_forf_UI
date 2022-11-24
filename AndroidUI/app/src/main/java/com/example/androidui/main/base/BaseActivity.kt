package com.example.androidui.main.base

import me.hgj.jetpackmvvm.base.activity.BaseVmVbActivity
import com.example.androidui.main.utlis.Tips
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    fun tip(msg: Any) {
        Tips.tip(this, msg.toString())
    }
}