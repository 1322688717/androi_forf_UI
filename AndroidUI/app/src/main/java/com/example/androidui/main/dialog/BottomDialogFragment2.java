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
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.androidui.R;
import com.example.androidui.databinding.Bottomdialogfragment2Binding;

public class BottomDialogFragment2 extends DialogFragment {

    Activity activity;
    Bottomdialogfragment2Binding binding;

    public BottomDialogFragment2(Activity activity) {
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = Bottomdialogfragment2Binding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.getWindow().setGravity(Gravity.BOTTOM);

            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.width =  WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(lp);

    }

    @Override
    public int getTheme() {
        return R.style.BottomDialogFragmnet;
    }
}
