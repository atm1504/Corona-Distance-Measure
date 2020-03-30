package `in`.atm1504.corona_distance_measure.main

import `in`.atm1504.corona_distance_measure.main.contract.IMainPresenter
import android.bluetooth.BluetoothAdapter
import android.content.Context

class MainPresenter(context: Context) : IMainPresenter {
    val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    override fun isBluetoothSupported(): Boolean {
        // To check if the device supports bluetooth or not
        return bluetoothAdapter != null
    }

    override fun isBluetoothEnabled(): Boolean {
        return bluetoothAdapter?.isEnabled as Boolean
    }
}