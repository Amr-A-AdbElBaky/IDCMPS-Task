package com.example.idcmps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.idcmps.databinding.LayoutMainActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding :LayoutMainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
