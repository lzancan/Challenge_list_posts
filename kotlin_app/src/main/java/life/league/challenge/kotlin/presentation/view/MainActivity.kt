package life.league.challenge.kotlin.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import life.league.challenge.kotlin.R
import life.league.challenge.kotlin.presentation.view.fragment.HomeFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment: Fragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_frame, fragment, fragment::class.simpleName)
            .addToBackStack(null).commit()
    }

}
