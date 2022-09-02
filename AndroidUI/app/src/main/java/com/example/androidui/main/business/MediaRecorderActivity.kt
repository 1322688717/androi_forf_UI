package com.example.androidui.main.business

import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidui.R
import com.example.androidui.databinding.ActivityMediaRecorderBinding
import com.example.androidui.databinding.BottomdialogfragmentBinding
import com.example.androidui.main.viewmodle.MediaRecorderViewModel

class MediaRecorderActivity : AppCompatActivity() {

    lateinit var binding: ActivityMediaRecorderBinding
    lateinit var viewmodel : MediaRecorderViewModel
    lateinit var mediaRecord : MediaRecorder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaRecorderBinding.inflate(layoutInflater)
        viewmodel = ViewModelProvider(this).get(MediaRecorderViewModel::class.java)
        setContentView(binding.root)
    }
}