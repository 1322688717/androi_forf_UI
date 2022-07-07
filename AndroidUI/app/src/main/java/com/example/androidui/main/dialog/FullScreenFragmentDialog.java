package com.example.androidui.main.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.androidui.R;
import com.example.androidui.main.https.OKHttp;

public class FullScreenFragmentDialog extends DialogFragment {


    Activity activity;

    public FullScreenFragmentDialog(Activity activity) {
        this.activity = activity;
    }

    public FullScreenFragmentDialog(int contentLayoutId, Activity activity) {
        super(contentLayoutId);
        this.activity = activity;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfragment ,container,false);
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public int getTheme() {

        return R.style.DialogFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        DisplayMetrics dm = new DisplayMetrics();
        //getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.getDisplay().getRealMetrics(dm);
        }
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setLayout(width, dm.heightPixels);


    }
}
