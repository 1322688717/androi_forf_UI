package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityTwoRcBinding;
import com.example.androidui.main.adapter.EditorAdapter;
import com.example.androidui.main.adapter.EditorTitleAdapter;

import java.util.ArrayList;
import java.util.List;

public class TwoRcActivity extends AppCompatActivity {

    ActivityTwoRcBinding binding;
    ArrayList<Integer> list_bottom = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTwoRcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initDate();

        initRcStyle();

        initRcTitle();
    }

    private void initRcTitle() {

    }

    private void initDate() {
        list_bottom.add((R.drawable.age));
        list_bottom.add((R.drawable.gender));
        list_bottom.add((R.drawable.style));
        list_bottom.add((R.drawable.skin_care));
        list_bottom.add((R.drawable.filter));
        list_bottom.add((R.drawable.lip_color));
        list_bottom.add((R.drawable.whimsy));
        list_bottom.add((R.drawable.cartoon));


    }

    private void initRcStyle() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
//        linearLayout.findFirstVisibleItemPosition();
//        binding.rcStyle.getChildAt()
        binding.rcStyle.setLayoutManager(linearLayoutManager);
        EditorAdapter editorAdapter = new EditorAdapter(list_bottom,TwoRcActivity.this,binding.rcTitle,linearLayoutManager,binding.rcStyle);
        binding.rcStyle.setAdapter(editorAdapter);
        binding.rcStyle.setItemAnimator(new DefaultItemAnimator());
    }



    /**
     * @author csc
     * @date 2018-11-15
     */
    public class CenterLayoutManager extends LinearLayoutManager {


        public CenterLayoutManager(Context context) {
            super(context);
        }

        public CenterLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);


        }

        public CenterLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);

        }

        @Override
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
            RecyclerView.SmoothScroller smoothScroller = new CenterSmoothScroller(recyclerView.getContext());
            smoothScroller.setTargetPosition(position);
            startSmoothScroll(smoothScroller);


        }

        private  class CenterSmoothScroller extends LinearSmoothScroller {

            CenterSmoothScroller(Context context) {
                super(context);
            }

            @Override
            public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
                return (boxStart + (boxEnd - boxStart) / 2) - (viewStart + (viewEnd - viewStart) / 2);
            }
        }

    }
}