package com.example.halengo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.halengo.databinding.ActivityVindskyddinfoBinding
import java.util.*

class vindskyddinfo : AppCompatActivity() {


    lateinit var binding: ActivityVindskyddinfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //skapar bindingobjekt
        binding= ActivityVindskyddinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Byter till rätt bild
        binding.finBild.setImageResource(intent.getIntExtra("bildExtra",0))

        //Byter till rätt rubrik
        binding.valtVindskydd.text = intent.getStringExtra("valtVindskydd")

        if(loggainfo.infoLoggad){
            //sparar loggad info i loggInfo
            val loggInfo: Information = intent.getSerializableExtra("loggad info") as Information
            //sparar det valda vindskyddets namn i valtVindskydd
            val valtVindskydd: String = intent.getStringExtra("valtVindskydd").toString()
            if(valtVindskydd == loggInfo.namn){
                //Checka i rätt info
                when(loggInfo.ved){
                    1 -> binding.vedRadio.check(R.id.ved_1_info)
                    2 -> binding.vedRadio.check(R.id.ved_2_info)
                    else -> binding.vedRadio.check(R.id.ved_3_info)
                }
                //Checka i rätt info
                when(loggInfo.skick){
                    1 -> binding.platsRadioInfo.check(R.id.skick_1_info)
                    else -> binding.platsRadioInfo.check(R.id.skick_2_info)
                }
                //Kolla om det är ledigt
                //fungerar ej, blir aldirg ledigt
                 val tid = Date(System.currentTimeMillis())
                if(tid >= loggInfo.bokningsTid){
                    binding.okupering.text ="Vindskyddet är ledigt"
                }
                else
                    binding.okupering.text ="Vindskyddet är inte ledigt"

            }


        }
    }
}