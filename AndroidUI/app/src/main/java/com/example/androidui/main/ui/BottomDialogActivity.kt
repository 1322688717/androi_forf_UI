package com.example.androidui.main.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.databinding.ActivityBottomDialogBinding
import com.example.androidui.main.adapter.StateAdapter
import com.example.androidui.main.viewmodle.BottomDialogViewModle
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.math.log

class BottomDialogActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBottomDialogBinding
    private lateinit var viewModle : BottomDialogViewModle
    private lateinit var bottomSheetDialog :BottomSheetDialog
    private  var  stateList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModle = ViewModelProvider(this).get(BottomDialogViewModle::class.java)

        initView()
        initOnclick()
        initViewModle()
        initStateList()
    }

    private fun initStateList() {
        stateList.add("已支付")
        stateList.add("未支付")
        stateList.add("再来一单")
    }

    private fun initViewModle() {
        viewModle.state.observe(this) {
            binding.tvState.text = it
        }
    }

    private fun initOnclick() {
        binding.tvState.setOnClickListener{
            initBottomDialog()

        }
    }


    /**
     * 初始化底部dialog
     */
    private fun initBottomDialog() {
        //创建布局
        var view : View = LayoutInflater.from(this).inflate(R.layout.bottom_dialog, null, false)
        val tvTitle: TextView = view.findViewById<TextView>(R.id.tv_my_up_title)
        val btnCancel: TextView = view.findViewById<TextView>(R.id.btn_cancel)
        val btnConfirm: TextView = view.findViewById<TextView>(R.id.btn_confirm)
        val rcState: RecyclerView = view.findViewById<RecyclerView>(R.id.timeList)
        rcState.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var adapter = StateAdapter(stateList)
        rcState.adapter = adapter
        //adapter.notifyDataSetChanged()
        //设置点击dialog外部不消失
//        bottomSheetDialog.setCanceledOnTouchOutside(true)
//        //核心代码 解决了无法去除遮罩问题
//        bottomSheetDialog.getWindow()!!.setDimAmount(0f)
        //设置布局
        bottomSheetDialog.setContentView(view)

        bottomSheetDialog.show()
    }

    private fun initView() {
        bottomSheetDialog = BottomSheetDialog(this)
    }
}