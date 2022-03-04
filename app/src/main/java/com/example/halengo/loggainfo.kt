package com.example.halengo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.halengo.databinding.ActivityLoggainfoBinding
import java.util.*
import java.io.Serializable

class loggainfo : AppCompatActivity() {
    // variabel som kan kommas åt från de andra programmen
    companion object{
        var infoLoggad: Boolean = false
    }

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

        fun vindskyddVal():String{
            return when(binding.vindskyddAlt.checkedRadioButtonId){
                R.id.tvatthallarna -> "Tvätthallarna"
                R.id.bergatorpet -> "Bergatorpet"
                R.id.alltidhult -> "Alltidhult"
                else -> "Myllevik"
            }
        }

        //funktion för att hämta vald tid
        fun hamtaTid(): Date{
            //skapar ett date objekt med info från datepicker och timepicker
            val minut = binding.timePicker.currentMinute
            val timme = binding.timePicker.currentHour
            val dag = binding.datePicker.dayOfMonth
            val manad = binding.datePicker.month
            val ar = binding.datePicker.year
            return Date(ar,manad,dag,timme,minut)
        }

        //funktion för att hämta vald info om ved

        fun vedVal():Int{
            return when(binding.vedAlt.checkedRadioButtonId){
                R.id.lite_ved -> 1
                R.id.lagom_ved -> 2
                else -> 3
            }
        }

        //funktion för att hämta vald info om skicket
        fun skickVal():Int{
            return when(binding.platsAlt.checkedRadioButtonId){
                R.id.skick_stada -> 1
                else -> 2
            }
        }

        //clicklistener för skicka knappen, hämtar all data och samlar i valdInfo
        binding.skickaInformation.setOnClickListener{
            //Här kommer kod för att skicka info till en server eller liknande vara om prototypen fortsätter att utvecklas
            //I nuläget skickar den bara till sig själv så det försvinner när man startar om appen

            val valdInfo = Information(vindskyddVal(),hamtaTid(),vedVal(),skickVal())

            val startaKartMeny = Intent(this,MainActivity::class.java)

            //Skickar valdInfo som extra till kartmenyn
            startaKartMeny.putExtra("loggad info",valdInfo)
            startaKartMeny.putExtra("test",true)
            //startar kartmenyn igen
            startActivity(startaKartMeny)
            loggainfo.infoLoggad = true

        }

    }
}
//class för att lagra infon
data class Information(val namn:String, val bokningsTid: Date,val ved:Int, val skick:Int) : Serializable

