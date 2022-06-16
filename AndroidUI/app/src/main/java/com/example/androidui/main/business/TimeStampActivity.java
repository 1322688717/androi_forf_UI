package com.example.androidui.main.business;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidui.databinding.ActivityTimeStampBinding;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * https://www.beijing-time.org/shijianchuo/  在线时间戳转换
 *
 * https://blog.csdn.net/JuncaiLiao/article/details/106672114?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522165520365016781685319703%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=165520365016781685319703&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-106672114-null-null.142^v14^pc_search_result_control_group,157^v14^control&utm_term=%E6%97%B6%E9%97%B4%E6%88%B3%E8%BD%AC%E6%8D%A2java&spm=1018.2226.3001.4187
 * 博客参考
 */

public class TimeStampActivity extends AppCompatActivity {

    ActivityTimeStampBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTimeStampBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date time = new Date(); // 获取当前时间
        String format = sdf.format(time);// 格式化时间


        // 时间转换为时间戳
        // getTime返回自1970年01月01日00时00分00秒(北京时间1970年01月01日08时00分00秒)起至现在的总毫秒数.
        // 时间戳是指自1970年01月01日00时00分00秒(北京时间1970年01月01日08时00分00秒)起至现在的总秒数
        // 单位换算：1秒=1000毫秒
        long timestamp = time.getTime() / 1000L;
        System.out.println("当前时间："+time);
        System.out.println("当前时间（格式化）："+format);
        System.out.println("当前时间戳："+timestamp);


        // 时间戳转化为时间
        Date time2 = new Date(timestamp * 1000L);
        String time3 = sdf.format(time2);
        System.out.println("时间戳转换来的时间："+time2);
        // 这里会有精度损失，是因为时间戳是秒数
        System.out.println("格式化后的转换时间："+time3);



        String time1 = "2020-2-7 12:30:56";
        int timel = 1686721524;
        System.out.println("将时间转为时间戳："+dateToStamp(time1));
        System.out.println("将时间戳转为时间："+stampToDate(timel));


    }


    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stamp = "";
        if (!"".equals(time)) {//时间不为空
            try {
                stamp = String.valueOf(sdf.parse(time).getTime()/1000);
            } catch (Exception e) {
                System.out.println("参数为空！");
            }
        }else {    //时间为空
            long current_time = System.currentTimeMillis();  //获取当前时间
            stamp = String.valueOf(current_time/1000);
        }
        return stamp;
    }


    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(int time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_Date = sdf.format(new Date(time * 1000L));
        return time_Date;

    }


}