package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.example.androidui.databinding.ActivitySearchBinding;
import com.example.androidui.main.adapter.RcAdapter;
import com.example.androidui.main.bean.ListOrder;
import com.example.androidui.main.https.OKHttp;
import com.example.androidui.main.listener.IGetDataListener;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding binding;
    List<ListOrder.DataDTO.ListDTO> list;
    Handler handler = new Handler(Looper.getMainLooper());
    RcAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initData();

        initEdit();
    }

    private void initEdit() {
        binding.editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 如果adapter不为空的话就根据编辑框中的内容来过滤数据
                if(adapter != null){
                    adapter.getFilter().filter(charSequence);
                }

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private void initData() {
        OKHttp.getInstance().getEnqueue("https://ddstar.palmmob.com/palmmob3_51/user/ListOrder?a=51&c=xiaomi&t=1655695458&u=744732&v=103&x=4b27bb1547a621f05830e1ddba962978&l=zh_CN&", new IGetDataListener() {
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this,LinearLayoutManager.VERTICAL,false);
        binding.rcList.setLayoutManager(linearLayoutManager);
        adapter =  new RcAdapter(SearchActivity.this,list);
        binding.rcList.setAdapter(adapter);
    }
}