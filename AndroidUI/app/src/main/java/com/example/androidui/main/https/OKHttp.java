package com.example.androidui.main.https;

import android.app.DownloadManager;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.androidui.main.bean.BeanLogin;
import com.example.androidui.main.listener.IGetDataListener;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

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
    public static final String TAG = "zcq";

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

    public void getHead( IGetDataListener listener){
        request = new Request.Builder()
                .url("https://www.gjzy352.top/prod-api/system/user/profile")
                .addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6Ijc3ODg1NWMyLWRlYjQtNDFiMC05YjY4LTQ0MzlkM2Q5NzRhYSJ9.0n8mwq-k5_H_7kn_4UhYQie7c7bFvbzDbLarkif5V01y91LJw58cWHxpGIW7pitqNogszkoR1jMkYbOt8slrfQ")
                .get()
                .build();
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                listener.onFailure(e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                listener.onSuccess(response.body().string());
            }
        });

    }

    /**
     * post请求  请求体是json格式
     * @param account
     * @param passworld
     * @param uuid
     * @param code
     * @param listener
     */
    public void postJson(String account,String passworld,String uuid,String code,IGetDataListener listener){


        /**
         * 应用拦截器
         */
        Interceptor appInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url();
                String s = url.url().toString();
                //---------请求之前-----
                Log.d(TAG,"应用拦截器url==="+s);
                Log.d(TAG,"app interceptor:begin");
                Response  response = chain.proceed(request);
                Log.d(TAG,"应用拦截器response==="+response);
                Log.d(TAG,"app interceptor:end");
                //---------请求之后------------
                return response;
            }

        };

        /**
         * 网络拦截器
         */
        Interceptor networkInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //---------请求之前-----
                Log.d(TAG,"网络拦截器request===="+request);
                Log.d(TAG,"network interceptor:begin");
                Response  response = chain.proceed(request);
                Log.d(TAG,"response===="+response);
                Log.d(TAG,"网络拦截器network interceptor:end");
                return response;
            }
        };
//
//        BeanLogin beanLogin =  new BeanLogin();
//        beanLogin.setCode(code);
//        beanLogin.setPassword(passworld);
//        beanLogin.setUsername(account);
//        beanLogin.setUuid(uuid);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

         String JSONObjectString = "{\n" +
                "    code:\"45\",\n" +
                "    uuid:\"d11242e967944c608595ef504bb1ae9a\",\n" +
                "    username:\"admin123\",\n" +
                "    password:\"admin123\"\n" +
                "}" ;
        //The data I want to send
        RequestBody requestBody = RequestBody.create(JSON, JSONObjectString);
        request = new Request.Builder()
                .url("http://121.5.233.252/prod-api/login")
                .post(requestBody)
                .build();
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(appInterceptor)
                        .addNetworkInterceptor(networkInterceptor)
                                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                listener.onFailure(e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                listener.onSuccess(response.body().string());
            }
        });
    }



}
