package com.example.androidui.main.https

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitUtlis {

    private val Base_URL = "https://api.vvhan.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(Base_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * 调用create方法，传入service接口对应的Class类型，创建一个该接口的动态代理对象
     *
     * 动态代理：有了这个动态代理对象后，我们就可以随意调用接口中定义的所有方法
     */
    fun <T> create(serviceClass: Class<T>) : T =  retrofit.create(serviceClass)

}