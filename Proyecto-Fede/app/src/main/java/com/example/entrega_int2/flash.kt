package com.example.entrega_int2

import android.annotation.SuppressLint
import android.content.Intent
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class flash : AppCompatActivity() {

    private lateinit var cameraManager: CameraManager
    private lateinit var btnFlash : Button
    private lateinit var textView: TextView
    private lateinit var btnVolver: Button
    private var flashActive = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)

        btnVolver = findViewById(R.id.btnVolver)

        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        btnFlash = findViewById(R.id.btnFlash)
        textView = findViewById(R.id.textView)

        btnFlash.setOnClickListener{
            toggleFlash()
        }

        btnVolver.setOnClickListener(){
            var volver = Intent(this, MainActivity::class.java)
            startActivity(volver)
        }
    }

    private fun toggleFlash(){
        try {
            val cameraId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraId, !flashActive)
            flashActive = !flashActive

            if(flashActive){
                btnFlash.setBackgroundColor(resources.getColor(R.color.red))
                textView.text = "Flash encendido"
                btnFlash.text = "Desactivar flash"
            }else{
                btnFlash.setBackgroundColor(resources.getColor(R.color.green))
                textView.text = "Flash apagado"
                btnFlash.text = "Activar flash"
            }

        }catch (e: CameraAccessException){
            e.printStackTrace()
            textView.text = "Error al acceder al flash"
        }
    }
}