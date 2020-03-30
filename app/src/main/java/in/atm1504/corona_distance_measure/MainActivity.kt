package `in`.atm1504.corona_distance_measure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import `in`.atm1504.corona_distance_measure.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
