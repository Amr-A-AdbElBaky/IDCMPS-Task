package com.example.idcmps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import com.example.idcmps.databinding.LayoutMainActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding :LayoutMainActivityBinding

    private val navController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        navHostFragment!!.navController
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickListener()
    }

    private fun initClickListener() {
        binding.appBar.imgRefresh.setOnClickListener {
            navController.navigateUp()
        }
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.appBar.imgRefresh.isVisible = destination.id == com.example.idcmps_listing.R.id.detailsFragment

        }
    }
}
