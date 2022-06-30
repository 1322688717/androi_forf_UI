package com.example.androidui.main.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidui.R;
import java.util.ArrayList;
import java.util.List;


public class EditorAdapter extends RecyclerView.Adapter<EditorAdapter.ViewHolder> {


    ArrayList<Integer> list_bottom = new ArrayList<>();
    TextView tv_title;
    ImageView img_head;
    List<Boolean> isSelects = new ArrayList<>();
    List<ConstraintLayout> cc_editor = new ArrayList<>();
    ArrayList<String> list_title = new ArrayList<>();
    Activity activity;
    RecyclerView recyclerView;
    int currentSelect;
    ArrayList<String> list_rc2_title = new ArrayList<>();
    ArrayList<Integer> list_rv2_imge = new ArrayList<>();
    ArrayList<Drawable> list_background = new ArrayList<>();

    public EditorAdapter(ArrayList<Integer> list_bottom, Activity activity, RecyclerView recyclerView) {
        this.list_bottom = list_bottom;
        this.activity = activity;
        this.recyclerView = recyclerView;
        initView(0);
        for (int i = 0;i<list_bottom.size();i++){
            isSelects.add(false);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.editor_item,parent,false);
        return new EditorAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        img_head.setImageResource(list_bottom.get(position));
        tv_title.setText(list_title.get(position));
//        cc_editor.get(position).setBackground(list_background.get(position));
        Log.e("TAG","position======"+position);
        cc_editor.get(position).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG",currentSelect+"");
                cc_editor.get(currentSelect).setBackground(activity.getDrawable(R.drawable.click_fales));
                currentSelect = position;
                //view.findViewById(R.id.cc_editor).
                initView(position);
                cc_editor.get(position).setBackground(activity.getDrawable(R.drawable.click_true));
//                view.setBackground(activity.getDrawable(R.drawable.click_true));
                Log.e("TAG","position======"+position);

            }
        });
    }



    @Override
    public int getItemCount() {
        return list_bottom.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            img_head = itemView.findViewById(R.id.img_head);
            cc_editor.add(itemView.findViewById(R.id.cc_editor));
            initTitle();
        }
    }


    private void setwhitleBackground(){

    }


    private void initView(int position) {
        recyclerView.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        initRc2();
        EditorTitleAdapter editorAdapter = new EditorTitleAdapter(list_rc2_title,list_rv2_imge,activity);
        recyclerView.setAdapter(editorAdapter);

        switch (position){
            case 0:
                initRc2();
                break;
            case 1:
                init1();
                break;
            case 2:
                init2();
                break;
            case 3:
                init3();
                break;
            case 4:
                init4();
                break;
            case 5:
                init5();
                break;
            case 6:
                init6();
                break;
            case 7:
                init7();
                break;

        }

    }

    private void init7() {
        list_rc2_title.clear();
        list_rc2_title.add("漫画");


        list_rv2_imge.clear();
        list_rv2_imge.add(R.drawable.comic);

    }

    private void init6() {
        list_rc2_title.clear();
        list_rc2_title.add("僵尸");
        list_rc2_title.add("小丑");




        list_rv2_imge.clear();
        list_rv2_imge.add(R.drawable.zombies);
        list_rv2_imge.add(R.drawable.clown);

    }

    private void init5() {
        list_rc2_title.clear();
        list_rc2_title.add("红色1");
        list_rc2_title.add("红色2");
        list_rc2_title.add("红色3");
        list_rc2_title.add("红色4");
        list_rc2_title.add("红色5");



        list_rv2_imge.clear();
        list_rv2_imge.add(R.drawable.lip1);
        list_rv2_imge.add(R.drawable.lip2);
        list_rv2_imge.add(R.drawable.lip3);
        list_rv2_imge.add(R.drawable.lip4);
        list_rv2_imge.add(R.drawable.lip5);

    }

    private void init4() {
        list_rc2_title.clear();
        list_rc2_title.add("白晢");
        list_rc2_title.add("清秀");
        list_rc2_title.add("哑灰");
        list_rc2_title.add("自然");
        list_rc2_title.add("黑白");



        list_rv2_imge.clear();
        list_rv2_imge.add(R.drawable.white_zhi);
        list_rv2_imge.add(R.drawable.handsome);
        list_rv2_imge.add(R.drawable.ash);
        list_rv2_imge.add(R.drawable.natural);
        list_rv2_imge.add(R.drawable.black_and_white);

    }

    private void init3() {

        list_rc2_title.clear();
        list_rc2_title.add("美白");
        list_rc2_title.add("磨皮");
        list_rc2_title.add("瘦脸");
        list_rc2_title.add("大眼");



        list_rv2_imge.clear();
        list_rv2_imge.add(R.drawable.whitening);
        list_rv2_imge.add(R.drawable.exfoliating);
        list_rv2_imge.add(R.drawable.thin_face);
        list_rv2_imge.add(R.drawable.big_eyes);

    }

    private void init1() {
        list_rv2_imge.clear();
        list_rv2_imge.add(R.drawable.man);
        list_rv2_imge.add(R.drawable.women);

        list_rc2_title.clear();
        list_rc2_title.add("男性");
        list_rc2_title.add("女性");
    }

    private void init2() {
        list_rv2_imge.clear();
        list_rv2_imge.add(R.drawable.style1);
        list_rv2_imge.add(R.drawable.style2);
        list_rv2_imge.add(R.drawable.style3);
        list_rv2_imge.add(R.drawable.style4);
        list_rv2_imge.add(R.drawable.style5);
        list_rv2_imge.add(R.drawable.style6);
        list_rv2_imge.add(R.drawable.style7);
        list_rv2_imge.add(R.drawable.style8);

        list_rc2_title.clear();
        list_rc2_title.add("铅笔");
        list_rc2_title.add("彩色铅笔");
        list_rc2_title.add("彩色糖块");
        list_rc2_title.add("彩神奈川油画");
        list_rc2_title.add("薰衣草");
        list_rc2_title.add("奇异油画");
        list_rc2_title.add("呐喊油画");
        list_rc2_title.add("彩哥特油画");

        list_background.clear();
        clearSelect();
        list_background.add(activity.getDrawable(R.drawable.click_true));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initRc2() {
       if (list_rv2_imge!=null){
           list_rv2_imge.clear();
       }
       if (list_rc2_title!=null){
           list_rc2_title.clear();
       }
        list_rc2_title.add("10岁");
        list_rc2_title.add("20岁");
        list_rc2_title.add("40岁");
        list_rc2_title.add("50岁");
        list_rc2_title.add("80岁");


        list_rv2_imge.add(R.drawable.ten_age);
        list_rv2_imge.add(R.drawable.twenty_age);
        list_rv2_imge.add(R.drawable.forty_age);
        list_rv2_imge.add(R.drawable.fifty_age);
        list_rv2_imge.add(R.drawable.eighty_age);
        clearSelect();
        list_background.add(activity.getDrawable(R.drawable.click_true));
    }

    public void clearSelect(){
        list_background.add(activity.getDrawable(R.drawable.click_fales));
        list_background.add(activity.getDrawable(R.drawable.click_fales));
        list_background.add(activity.getDrawable(R.drawable.click_fales));
        list_background.add(activity.getDrawable(R.drawable.click_fales));
        list_background.add(activity.getDrawable(R.drawable.click_fales));
        list_background.add(activity.getDrawable(R.drawable.click_fales));
        list_background.add(activity.getDrawable(R.drawable.click_fales));
        list_background.add(activity.getDrawable(R.drawable.click_fales));
    }


    private void initTitle() {
        list_title.add("年龄");
        list_title.add("性别");
        list_title.add("风格");
        list_title.add("美颜");
        list_title.add("滤镜");
        list_title.add("唇色");
        list_title.add("搞怪");
        list_title.add("卡通");
    }
}
