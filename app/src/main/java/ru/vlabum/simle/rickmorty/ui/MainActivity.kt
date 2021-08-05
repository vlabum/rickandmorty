package ru.vlabum.simle.rickmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import io.reactivex.rxjava3.disposables.CompositeDisposable
import ru.vlabum.simle.rickmorty.R

class   MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }
}