package com.example.entrega_int2

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import java.io.File


@Suppress("DEPRECATION")
class audio : AppCompatActivity() {

    private lateinit var btnGrabar: Button
    private lateinit var btnParar: Button
    private lateinit var btnRep: Button
    private lateinit var mr: MediaRecorder

    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)
        var path = File(getExternalFilesDir(Environment.DIRECTORY_AUDIOBOOKS), "audio.3gp")
        btnGrabar = findViewById(R.id.btnGrabar)
        btnParar = findViewById(R.id.btnParar)
        btnRep = findViewById(R.id.btnRep)

        mr = MediaRecorder()
        btnGrabar.isEnabled = false
        btnParar.isEnabled = false

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO,
                                                                   android.Manifest.permission.WRITE_EXTERNAL_STORAGE),111)
            btnGrabar.isEnabled = true


        //Comienza a grabar
        btnGrabar.setOnClickListener {
            mr.setAudioSource(MediaRecorder.AudioSource.MIC)
            mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            mr.setOutputFile(path)
            mr.prepare()
            mr.start()
            btnParar.isEnabled=true
            btnGrabar.isEnabled=false
        }

        //Parar de grabar
        btnParar.setOnClickListener {
            mr.stop()
            btnParar.isEnabled=false
            btnGrabar.isEnabled=true
        }

        //Reproducir
        btnRep.setOnClickListener {
            var mp = MediaPlayer()
            mp.setDataSource(path.absolutePath)
            mp.prepare()
            mp.start()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==111 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            btnGrabar.isEnabled=true
    }

}


