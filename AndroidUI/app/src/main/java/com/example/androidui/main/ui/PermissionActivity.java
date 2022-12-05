package com.example.androidui.main.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androidui.R;
import com.example.androidui.databinding.ActivityPermissionBinding;
import com.permissionx.guolindev.PermissionX;

public class PermissionActivity extends AppCompatActivity {

    ActivityPermissionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPermissionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGetPermission.setOnClickListener(view -> btnGetPermission());
    }

    private void btnGetPermission() {
        PermissionX.init(this)
                .permissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)

                .request(((allGranted, grantedList, deniedList) -> {
                    if (allGranted) {
                        Toast.makeText(this, "您同意了所有权限!", Toast.LENGTH_SHORT).show();
                       // createLog4jLocal();

                    } else {
                        Toast.makeText(this, "您拒绝了以下权限:"+deniedList, Toast.LENGTH_SHORT).show();

                    }
                }));

//        PermissionX.init(PermissionActivity.this)
//                .permissions(Manifest.permission.READ_CONTACTS, Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE)
//                .request { allGranted, grantedList, deniedList ->
//            if (allGranted) {
//                Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
//            } else {
//                Toast.makeText(this, "These permissions are denied: $deniedList", Toast.LENGTH_LONG).show()
//            }
//        }

    }
}