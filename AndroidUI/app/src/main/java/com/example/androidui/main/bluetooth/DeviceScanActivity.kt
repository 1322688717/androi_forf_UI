package com.example.androidui.main.bluetooth

import android.Manifest
import android.app.ListActivity
import android.bluetooth.BluetoothAdapter
import android.content.pm.PackageManager
import android.os.Handler
import androidx.core.app.ActivityCompat

private const val SCAN_PERIOD: Long = 10000

/**
 * Activity for scanning and displaying available BLE devices.
 */
class DeviceScanActivity(
    private val bluetoothAdapter: BluetoothAdapter,
    private val handler: Handler
) : ListActivity() {

    private var mScanning: Boolean = false






}