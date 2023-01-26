package com.example.progressproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_satu)

        val btnSkip = findViewById<TextView>(R.id.tvSkip)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnSkip.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnNext.setOnClickListener {
            val intent = Intent(this,OnboardingDuaActivity::class.java)
            startActivity(intent)
        }

    }
}
