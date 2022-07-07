package com.example.androidui.main.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityDialogBinding;
import com.example.androidui.main.dialog.BottomDialogFragment2;
import com.example.androidui.main.dialog.BotttonDialogFragment;
import com.example.androidui.main.dialog.FullScreenFragmentDialog;

public class DialogActivity extends AppCompatActivity {

    ActivityDialogBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initview();

    }

    private void initview() {
        binding.btnDefaultDialog.setOnClickListener(view -> btnDefaultDialog());
        binding.btnCustomDialog.setOnClickListener(view ->btnCustomDialog() );
        binding.btnProgressDialog.setOnClickListener(view -> btnProgressDialog());
        binding.btnFullscrrenFragmentDialog.setOnClickListener(view ->btnFragmentDialog() );
        binding.btnBottonFragmentDialog.setOnClickListener(view -> btnBottonFragmentDialog());
        binding.btnBottonFragmentDialog2.setOnClickListener(view ->btnBottonFragmentDialog2() );
        ProgressBar progressBar1 = binding.progressbarOne;
        ProgressBar progressBar2 = binding.progressbarTwo;
    }

    /**
     * 底部导航二
     */
    private void btnBottonFragmentDialog2() {
        BottomDialogFragment2 bottomDialogFragment2 = new BottomDialogFragment2(this);
        bottomDialogFragment2.show(getSupportFragmentManager(),"bottomdialog2");
    }


    /**
     * 底部dialog
     */
    private void btnBottonFragmentDialog() {
        BotttonDialogFragment botttonDialogFragment = new BotttonDialogFragment();
        botttonDialogFragment.show(getSupportFragmentManager(),"bottomDialog");
    }


    /**
     * fragmnetDialog 使用方法
     */
    private void btnFragmentDialog() {
        FullScreenFragmentDialog fullScreenFragmentDialog = new FullScreenFragmentDialog(this);
        fullScreenFragmentDialog.show(getSupportFragmentManager(),"123");

    }


    /**
     * 自定义dialog
     */
    private void btnCustomDialog() {
        AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(DialogActivity.this, R.style.MyDialog);
        alterDiaglog.setView(R.layout.dialog_1);//加载进去
        AlertDialog dialog = alterDiaglog.create();
        //显示
        dialog.show();
        //自定义的东西
        //放在show()之后，不然有些属性是没有效果的，比如height和width
//        Window dialogWindow = dialog.getWindow();
//        WindowManager m = getWindowManager();
//        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
//        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
//        // 设置高度和宽度
//        p.height = (int) (d.getHeight() * 0.4); // 高度设置为屏幕的0.6
//        p.width = (int) (d.getWidth() * 0.6); // 宽度设置为屏幕的0.65
//
//        p.gravity = Gravity.TOP;//设置位置
//
//        p.alpha = 0.8f;//设置透明度
//        dialogWindow.setAttributes(p);


    }

    /**
     * 等待进度条
     */
    private void btnProgressDialog() {
        final int MAX = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("我是个等待的Dialog");
        progressDialog.setMessage("等待中");
        progressDialog.setIndeterminate(true);
        //progressDialog.setCancelable(false);      设置区域外不可点击
        progressDialog.show();

    }

    /**
     * 默认dialog
     */
    private void btnDefaultDialog() {
        final AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(DialogActivity.this);
        //alterDiaglog.setIcon(R.drawable.icon);//图标
        alterDiaglog.setTitle("简单的dialog");//文字
        alterDiaglog.setMessage("生存还是死亡");//提示消息
        //积极的选择
        alterDiaglog.setPositiveButton("生存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this,"点击了生存",Toast.LENGTH_SHORT).show();
            }
        });
        //消极的选择
        alterDiaglog.setNegativeButton("死亡", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this,"点击了死亡",Toast.LENGTH_SHORT).show();
            }
        });
        //中立的选择
        alterDiaglog.setNeutralButton("不生不死", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this,"点击了不生不死",Toast.LENGTH_SHORT).show();
            }
        });

        //显示
        alterDiaglog.show();

    }
}