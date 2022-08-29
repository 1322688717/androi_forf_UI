package com.example.androidui.main.api

import com.example.androidui.main.https.RetrofitUtlis

object Response {
    val responseService = RetrofitUtlis.create(APIService::class.java)

}