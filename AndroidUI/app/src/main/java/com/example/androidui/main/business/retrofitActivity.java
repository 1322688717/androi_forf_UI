package com.example.androidui.main.business;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import com.example.androidui.databinding.ActivityRetrofitBinding;
import com.example.androidui.main.api.Response;
import com.example.androidui.main.bean.SaoBean;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;

public class retrofitActivity extends AppCompatActivity {

    private ActivityRetrofitBinding binding;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetrofitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGetRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.INSTANCE.getResponseService().getSao("json").enqueue(new Callback<SaoBean>() {
                    @Override
                    public void onResponse(Call<SaoBean> call, retrofit2.Response<SaoBean> response) {
                        Log.e("TAG","response======"+response);
                        assert response.body() != null;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                binding.tvContent.setText(response.body().getIshan());
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<SaoBean> call, Throwable t) {
                        Log.e("TAG","t======"+t);
                    }
                });
            }
        });


    }
}