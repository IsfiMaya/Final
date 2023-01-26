package com.example.progressproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MataPelajaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matapelajaran)
        val btnBack = findViewById<Button>(R.id.btnMapel)
        btnBack.setOnClickListener {
            val intent = Intent(this, HomeGuruActivity::class.java)
            startActivity(intent)
        }
    }
}