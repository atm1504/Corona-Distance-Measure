package `in`.atm1504.corona_distance_measure.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.atm1504.corona_distance_measure.R
import `in`.atm1504.corona_distance_measure.main.contract.IMainFragment
import `in`.atm1504.corona_distance_measure.main.contract.IMainPresenter
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainFragment : Fragment(), IMainFragment {

    lateinit var mainPresenter: IMainPresenter
    private val REQUEST_ENABLE_BT = 1
    val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    companion object {
        fun newInstance() =
            MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainPresenter = MainPresenter(requireContext())
        if (!mainPresenter.isBluetoothSupported()) {
            showAlert(getString(R.string.not_supported), getString(R.string.error))
        } else {
            enableBluetooth()
        }
    }


    override fun enableBluetooth() {
        if (bluetoothAdapter?.isEnabled == false) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
        }
    }

    override fun showAlert(message: String, title: String) {
        val builder = AlertDialog.Builder(requireContext())
        //set title for alert dialog
        builder.setTitle(title)
        //set message for alert dialog
        builder.setMessage(message)
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setNeutralButton("OK") { dialogInterface, which ->
            Toast.makeText(requireContext(), "clicked cancel\n operation cancel", Toast.LENGTH_LONG)
                .show()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

}
