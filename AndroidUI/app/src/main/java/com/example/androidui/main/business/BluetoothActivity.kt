package com.example.androidui.main.business

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.androidui.R
import me.hgj.jetpackmvvm.ext.util.TAG

class BluetoothActivity : AppCompatActivity() {


    private val receiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            when(intent.action) {
                BluetoothDevice.ACTION_FOUND -> {
                    val device: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    val deviceName = if (ActivityCompat.checkSelfPermission(
                            this@BluetoothActivity,
                            Manifest.permission.BLUETOOTH_CONNECT
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {

                        return
                    } else {

                    }
                    device?.name
                    val deviceHardwareAddress = device?.address // MAC address
                    Log.e("TAG", "deviceHardwareAddress=====$deviceHardwareAddress")
                }
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)


        //获取 BluetoothAdapter
        val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
        Log.d(TAG, "蓝牙是否打开: " + bluetoothAdapter?.isEnabled)


        //启用蓝牙
        if (bluetoothAdapter?.isEnabled == false) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                return
            }
            startActivityForResult(enableBtIntent, 0)
        }

        //查找设备
        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        registerReceiver(receiver, filter)

        var wifiInfo = getWifiInfo(this)
        var sInfo = getAroundWifiDeciceInfo(this)


    }


    /**
     * 获取WifiInfo
     * @param mContext
     * @return
     */
    fun getWifiInfo(mContext: Context): WifiInfo? {
        val mWifiManager =
            mContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        return mWifiManager.connectionInfo
    }

    /**
     * 搜索到的周边WIFI信号信息
     * @param mContext
     * @return
     */
    fun getAroundWifiDeciceInfo(mContext: Context): String? {
        val sInfo = StringBuffer()
        val mWifiManager = mContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        //WifiInfo mWifiInfo = mWifiManager.getConnectionInfo();
        val scanResults = mWifiManager.scanResults //搜索到的设备列表
        for (scanResult in scanResults) {
            sInfo.append(
                """
设备名：${scanResult.SSID} 信号强度：${scanResult.level}/n :${
                    WifiManager.calculateSignalLevel(
                        scanResult.level,
                        4
                    )
                }"""
            )
        }
        return sInfo.toString()
    }
}