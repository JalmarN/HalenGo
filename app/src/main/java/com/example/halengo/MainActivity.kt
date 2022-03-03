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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //kod för knappar
        binding.tvatthallaraButton.setOnClickListener {
            val intent = Intent(this,exempel_vindskydd::class.java)
            startActivity(intent)
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
}