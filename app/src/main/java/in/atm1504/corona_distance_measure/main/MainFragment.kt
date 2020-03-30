package `in`.atm1504.corona_distance_measure.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.atm1504.corona_distance_measure.R
import `in`.atm1504.corona_distance_measure.main.contract.IMainFragment
import `in`.atm1504.corona_distance_measure.main.contract.IMainPresenter

class MainFragment : Fragment(), IMainFragment {

    lateinit var mainPresenter: IMainPresenter

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
    }

}
