package com.example.halengo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.halengo.databinding.ActivityVindskyddinfoBinding

class vindskyddinfo : AppCompatActivity() {
    //Konstant värde som inte ändras medans vindskyddsinfo finns
    //Defineras av den tryckta knappen på kartan
    companion object{
        const val nuvarandeVindskydd: String = "nuvarande Vindskydd"
    }

    lateinit var binding: ActivityVindskyddinfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //skapar bindingobjekt
        binding= ActivityVindskyddinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Byter till rätt bild
        binding.finBild.setImageResource(intent.getIntExtra("bildExtra",0))
    }
}