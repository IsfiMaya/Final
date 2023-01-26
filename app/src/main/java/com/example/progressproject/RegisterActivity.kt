package com.example.progressproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val btnSiswa = findViewById<Button>(R.id.btnSiswa)
        val btnGuru = findViewById<Button>(R.id.btnGuru)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        btnSiswa.setOnClickListener {
            val intent = Intent(this, RegisterSiswaActivity::class.java)
            startActivity(intent)
        }

        btnGuru.setOnClickListener {
            val intent = Intent(this, RegisterGuruActivity::class.java)
            startActivity(intent)
        }

        btnKembali.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}