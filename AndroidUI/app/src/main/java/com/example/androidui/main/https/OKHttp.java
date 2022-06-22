package com.example.androidui.main.https;

import android.app.DownloadManager;

import com.example.androidui.main.listener.IGetDataListener;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
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

    public void getRequest(String url , IGetDataListener listener){
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
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
