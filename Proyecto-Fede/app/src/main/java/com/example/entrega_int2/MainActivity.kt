package com.example.entrega_int2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Intent


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFlash : Button = findViewById(R.id.btnFlash)
        val btnCamara : Button = findViewById(R.id.btnCamara)
        val btnGPS : Button = findViewById(R.id.btnGPS)
        val btnAudio : Button = findViewById(R.id.btnAudio)

        btnFlash.setOnClickListener(){
            var cambio = Intent(this, flash::class.java)
            startActivity(cambio)
        }

        btnCamara.setOnClickListener(){
            var cambio = Intent(this, activity_cameras::class.java)
            startActivity(cambio)
        }
        btnGPS.setOnClickListener(){
            var cambio = Intent(this, MapsActivity::class.java)
            startActivity(cambio)
        }

        btnAudio.setOnClickListener(){
            var cambio = Intent(this, audio::class.java)
            startActivity(cambio)
        }



    }
}