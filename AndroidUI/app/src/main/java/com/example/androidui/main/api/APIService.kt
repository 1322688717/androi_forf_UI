package com.example.androidui.main.api

import com.example.androidui.main.bean.SaoBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/api/sao")
    fun getSao(@Query("type") type : String) : Call<SaoBean>
}