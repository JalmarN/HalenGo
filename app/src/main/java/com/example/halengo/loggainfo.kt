package com.example.halengo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import com.example.halengo.databinding.ActivityLoggainfoBinding

class loggainfo : AppCompatActivity() {

    lateinit var binding: ActivityLoggainfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoggainfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //sätter tidsväljaren i 24h format
        binding.timePicker.setIs24HourView(true)
        //sätter den minsta tiden till nutid på datumväljaren och tidväljaren
        binding.datePicker.setMinDate(System.currentTimeMillis() - 1000)

        //sätter den maximala bokningstiden till 2 dagar i framtiden
        binding.datePicker.setMaxDate(System.currentTimeMillis() +86400000)

    }
}