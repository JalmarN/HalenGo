package com.example.halengo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.halengo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //kod för knappar
        binding.tvatthallaraButton.setOnClickListener {
            val intent = Intent(this,exempel_vindskydd::class.java)
            startActivity(intent)
        }
    }
}