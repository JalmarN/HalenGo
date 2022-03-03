package com.example.halengo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class vindskyddinfo : AppCompatActivity() {
    companion object{
        const val nuvarandeVindskydd = "nuvarande Vindskydd"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vindskyddinfo)


    }
    private fun bildVal(){
        //använd imageview.setimageresource(id)
    }
}