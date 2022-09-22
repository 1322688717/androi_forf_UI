package com.example.androidui.main.business;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidui.databinding.ActivityOkHttpBinding;
import com.example.androidui.main.base.BaseActivity;
import com.example.androidui.main.bean.HFWeather;
import com.example.androidui.main.https.OKHttp;
import com.example.androidui.main.listener.IGetDataListener;
import com.example.androidui.main.untls.Logs;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;




public class OkHttpActivity extends BaseActivity {

    com.example.androidui.databinding.ActivityOkHttpBinding binding;
    String url = "https://devapi.qweather.com/v7/weather/now?location=101010100&key=66d721a1d6024ca8b6c257fcab036de7";
    public static final String TAG = "zcq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOkHttpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnStart1.setOnClickListener(view ->btnStart() );
        binding.btnStart2.setOnClickListener(view -> btnStart2());
        binding.btnPostJson.setOnClickListener(View ->PostJson());
        binding.btnGetHead.setOnClickListener(View -> btnGetHead());
    }

    private void btnGetHead() {
        OKHttp.getInstance().getHead(new IGetDataListener() {
            @Override
            public void onSuccess(Object dataobj) {
                Log.d(TAG,"dataobj===="+dataobj);
            }

            @Override
            public void onFailure(Object reasonOBJ) {
                Log.d(TAG,"reasonOBJ==="+reasonOBJ);
            }
        });
    }

    private void PostJson() {
        OKHttp.getInstance().postJson("anmin123", "admin123", "", "", new IGetDataListener() {
            @Override
            public void onSuccess(Object dataobj) {
                Log.d(TAG,"dataobj===="+dataobj);
            }

            @Override
            public void onFailure(Object reasonOBJ) {
                Log.d(TAG,"reasonOBJ==="+reasonOBJ);
            }
        });
    }

    /**
     * 通过json直接拿自己想要的数据
     */

    private void btnStart2() {
        OKHttp.getInstance().getEnqueue(url, new IGetDataListener() {
            @Override
            public void onSuccess(Object dataobj) {
                try {
                    JSONObject jsonObject = new JSONObject(dataobj.toString());
                    JSONObject now = jsonObject.optJSONObject("now");
                    Logs.e("now===="+now);
                    String temp = now.optString("temp");
                    Logs.e("temp===="+temp);
                    showTemp2(temp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Object reasonOBJ) {

            }
        });
    }

    private void showTemp2(String temp) {
        binding.tvTemp2.setText("温度："+temp);
    }

    /**
     * 通过gson将json转换成实体类来进行ui操作
     */

    /**
     *    第一步拿到json字符串
     *    第二部将json字符串转成jsonobj
     *    第三步  new Gson
     *    第四部  通过gson将json转换成实体类
     */

    private void btnStart() {
        OKHttp.getInstance().getEnqueue(url, new IGetDataListener() {
            @Override
            public void onSuccess(Object dataobj) {
                Logs.e("第一步拿到json字符串"+dataobj.toString());
                try {
                    JSONObject jsonObject = new JSONObject(dataobj.toString());
                    Gson gson = new Gson();
                    HFWeather hfWeather = gson.fromJson(jsonObject.toString(), HFWeather.class);
                    showTemp(hfWeather);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Object reasonOBJ) {

            }
        });
    }

    private void showTemp(HFWeather hfWeather) {
        binding.tvTemp1.setText("温度："+hfWeather.getNow().getTemp());
    }
}