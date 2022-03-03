package com.example.halengo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.halengo.databinding.ActivityLoggainfoBinding

class loggainfo : AppCompatActivity() {

    lateinit var binding: ActivityLoggainfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoggainfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}