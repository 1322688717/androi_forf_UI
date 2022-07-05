package com.example.androidui.main.https;

import android.app.DownloadManager;

import com.example.androidui.main.listener.IGetDataListener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttp {
    private static OKHttp instance = null;
    public static OKHttp getInstance() {
        if (instance == null){
            instance = new OKHttp();
        }
        return instance;
    }

    Request request;
    OkHttpClient okHttpClient;

    /**
     * get异步请求
     * @param url
     * @param listener
     */
    public void getEnqueue(String url , IGetDataListener listener){
         request = new Request.Builder()
                .url(url)
                .build();
         okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                listener.onSuccess(response.body().string());
            }
        });
    }

    /**
     * get  同步请求
     * @param url
     * @param listener
     */
    public void getExecute(String url , IGetDataListener listener){
        request = new Request.Builder()
                .url(url)
                .build();
        okHttpClient = new OkHttpClient();
        try {
            Response response = okHttpClient.newCall(request).execute();
            listener.onSuccess(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * post  同步请求
     * @param url
     * @param listener
     */
    public void postSync(String url , IGetDataListener listener){
        FormBody formBody = new FormBody.Builder().add("a","1").add("b","2").build();
        request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        okHttpClient = new OkHttpClient();
        try {
            Response response = okHttpClient.newCall(request).execute();
            listener.onSuccess(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * post 异步请求
     * @param url
     * @param listener
     */
    public void postAsync(String url , IGetDataListener listener) {
        FormBody formBody = new FormBody.Builder().add("a","1").add("b","2").build();
        request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                listener.onSuccess(response.body().string());
            }
        });
    }

}
