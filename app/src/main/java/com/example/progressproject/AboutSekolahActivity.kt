package com.example.progressproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutSekolahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_sekolah)
        val btnMaps = findViewById<Button>(R.id.btnMaps)
        val btnTata = findViewById<Button>(R.id.btnTata)
        val btnProfilSekolah = findViewById<Button>(R.id.btnProfilSekolah)

        btnTata.setOnClickListener {
            val intent = Intent(this, TatatertibActivity::class.java)
            startActivity(intent)
        }

        btnProfilSekolah.setOnClickListener {
            val intent = Intent(this, ProfilSekolahActivity::class.java)
            startActivity(intent)
        }

        btnMaps.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }
}