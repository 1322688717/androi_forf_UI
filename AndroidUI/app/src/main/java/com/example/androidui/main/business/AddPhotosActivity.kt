package com.example.androidui.main.business

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidui.R
import com.example.androidui.databinding.ActivityAddPhotosBinding
import com.example.androidui.databinding.ActivityMediaRecorderBinding
import com.example.androidui.main.adapter.AddPhotosAdapter
import com.example.androidui.main.viewmodle.AddPhotosViewModel
import com.example.androidui.main.viewmodle.MediaRecorderViewModel

class AddPhotosActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddPhotosBinding
    lateinit var viewModel: AddPhotosViewModel
    lateinit var adapter: AddPhotosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPhotosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(AddPhotosViewModel::class.java)

        initView()
    }

    private fun initView() {
        binding.apply {
            viewModel.listData.observe(this@AddPhotosActivity){
                adapter = AddPhotosAdapter(it)
                rcPhoto.adapter = adapter
                rcPhoto.layoutManager = LinearLayoutManager(this@AddPhotosActivity,LinearLayoutManager.VERTICAL,false)
            }


            rcPhoto.setOnClickListener{
                viewModel.setListData()
            }
           // adapter.setOnItemClickListener()


        }
    }
}