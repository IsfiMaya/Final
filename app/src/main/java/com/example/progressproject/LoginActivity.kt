package com.example.progressproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val buttonSiswa = findViewById<Button>(R.id.buttonSiswa)
        val buttonGuru = findViewById<Button>(R.id.buttonGuru)
        buttonSiswa.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        buttonGuru.setOnClickListener {
            val intent = Intent(this, LoginGuru::class.java)
            startActivity(intent)
        }
        val buttonRegister = findViewById<Button>(R.id.buttonSignin)
        buttonRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}