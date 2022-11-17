package com.example.androidui.main.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidui.R

class HomeFragment : Fragment() {
    companion object {
        val instance: HomeFragment by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            HomeFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}