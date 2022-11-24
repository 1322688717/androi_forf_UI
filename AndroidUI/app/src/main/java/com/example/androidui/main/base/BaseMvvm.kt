package com.example.androidui.main.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import me.hgj.jetpackmvvm.base.activity.BaseVmVbActivity
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

 abstract class BaseMvvm<VM : BaseViewModel, VB : ViewBinding> : BaseVmVbActivity<VM, VB>() {

     override fun createObserver() {

     }

     override fun dismissLoading() {

     }

     abstract override fun initView(savedInstanceState: Bundle?)

     override fun showLoading(message: String) {

     }
 }