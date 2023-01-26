package com.example.progressproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TatatertibActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tata_tertib)
        val btnKembali = findViewById<Button>(R.id.btnKembali)
        btnKembali.setOnClickListener {
            val intent = Intent(this, AboutSekolahActivity::class.java)
            startActivity(intent)
        }
    }
}