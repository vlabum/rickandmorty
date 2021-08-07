package ru.vlabum.simle.rickmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.vlabum.simle.rickmorty.R

class   MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    private var navController: NavController? = null
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottomNavigationView = findViewById(R.id.navigation_view)
        bottomNavigationView.setupWithNavController(navController!!)
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }
}