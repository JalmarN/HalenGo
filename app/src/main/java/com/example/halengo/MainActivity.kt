package com.example.halengo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import com.example.halengo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Skapar bindingobjektet
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //clicklisterners för knappar på kartan
        //Skickar namnet på vindskyddet och bildens id till infoknapp() funktionen
        binding.tvatthallarnaKnapp.setOnClickListener {
            infoKnapp("Tvätthallarna",R.drawable.tvatthallarna_cover)
        }
        binding.myllevikKnapp.setOnClickListener {
            infoKnapp("Myllevik",R.drawable.myllevik_cover)
        }
        binding.bergatorpetKnapp.setOnClickListener {
            infoKnapp("Bergatorpet",R.drawable.bergatorpet_cover)
        }
        binding.alltidhultKnapp.setOnClickListener {
            infoKnapp("Alltidhult",R.drawable.alltidhult_cover)
        }
        //temp knapp
        binding.button.setOnClickListener {
            val test = Intent(this,loggainfo::class.java)
            startActivity(test)
        }
    }

    //kod för kamera knapp
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.layout_menu,menu)

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.camera_button -> {
                val camera_open = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(camera_open)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    //funktion för knappar som startar vindskyddinfo aktiviten. bildId berättar vilken bild som skall användas
     private fun infoKnapp(valtVindskydd: String, bildId: Int){
        //Skapar intent för att öppna vindskyddinfo
        val tillInfo = Intent(this,vindskyddinfo::class.java)

        //Skickar det valda vindskyddet och bildId:t som två extras till vindskyddinfo

        tillInfo.putExtra("valtVindskydd",valtVindskydd)
        tillInfo.putExtra("bildExtra",bildId)


        startActivity(tillInfo)
    }

}
