package com.example.entrega_int2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_cameras : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cameras)

        val btnBackCamera : Button = findViewById(R.id.btnBackCamera)
        val btnFrontCamera : Button = findViewById(R.id.btnFrontCamera)

        btnBackCamera.setOnClickListener {
            var cambio = Intent(this, activity_back_camera::class.java)
            startActivity(cambio)
        }

        btnFrontCamera.setOnClickListener {
            var cambio = Intent(this, activity_fron_camera::class.java)
            startActivity(cambio)
        }

    }
}