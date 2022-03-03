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
        binding.tvatthallarnaKnapp.setOnClickListener {
            infoKnapp("Tvätthallarna")
        }
        binding.norraKnapp.setOnClickListener {
            infoKnapp("Norra")
        }
        binding.bergatorpetKnapp.setOnClickListener {
            infoKnapp("Bergatorpet")
        }
        binding.alltidhultKnapp.setOnClickListener {
            infoKnapp("Alltidhult")
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
    //funktion för knappar som startar vindskyddinfo aktiviten
     private fun infoKnapp(valtVindskydd: String){
        //Skapar intent för att öppna vindskyddinfo
        val tillInfo = Intent(this,vindskyddinfo::class.java)

        //Skickar det valda vindskyddet som en extra till konstanten nuvarandeVindskydd i vindskyddinfo
         tillInfo.putExtra(vindskyddinfo.nuvarandeVindskydd,valtVindskydd)

        startActivity(tillInfo)
    }
}
