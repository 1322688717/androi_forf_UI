package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityRcBinding;
import com.example.androidui.main.adapter.RcAdapter;
import com.example.androidui.main.adapter.RcAdapter2;
import com.example.androidui.main.bean.ListOrder;
import com.example.androidui.main.https.OKHttp;
import com.example.androidui.main.listener.IGetDataListener;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RcActivity extends AppCompatActivity {

    ActivityRcBinding binding;
    List<ListOrder.DataDTO.ListDTO> list;
    Handler handler = new Handler(Looper.getMainLooper());
    List photo = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initData();

        initdata2();

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initdata2() {
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        photo.add(getDrawable(R.drawable.picture));
        initrc2();
    }

    private void initrc2() {
       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RcActivity.this,LinearLayoutManager.VERTICAL,false);

        binding.rcHorizontal.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
        RcAdapter2 adapter2 =  new RcAdapter2(RcActivity.this,photo);
        binding.rcHorizontal.setAdapter(adapter2);
    }

    private void initData() {
        OKHttp.getInstance().getRequest("https://ddstar.palmmob.com/palmmob3_51/user/ListOrder?a=51&c=xiaomi&t=1655695458&u=744732&v=103&x=4b27bb1547a621f05830e1ddba962978&l=zh_CN&", new IGetDataListener() {
            @Override
            public void onSuccess(Object dataobj) {
                Log.e("TAG",dataobj.toString());
                try {
                    JSONObject jsonObject = new JSONObject(dataobj.toString());
                    int code = jsonObject.getInt("code");
                    Log.e("TAG",code+"");
                    if(code == 0){
                        Gson gson = new Gson();
                        ListOrder listOrder = gson.fromJson(dataobj.toString(),ListOrder.class);
                        list = listOrder.getData().getList();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                initRc();
                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Object reasonOBJ) {

            }
        });
    }

    private void initRc() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RcActivity.this,LinearLayoutManager.VERTICAL,false);
        binding.rcList.setLayoutManager(linearLayoutManager);
        RcAdapter adapter =  new RcAdapter(RcActivity.this,list);
        binding.rcList.setAdapter(adapter);
        binding.rcList.addItemDecoration(new DividerItemDecoration(RcActivity.this, DividerItemDecoration.VERTICAL));
        binding.rcList.setItemAnimator(new DefaultItemAnimator());
    }
}