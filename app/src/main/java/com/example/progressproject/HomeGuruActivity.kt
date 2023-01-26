package com.example.progressproject

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class HomeGuruActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_guru)
        val btnProfil = findViewById<ImageView>(R.id.imgViewProfil)
        val btnNilai = findViewById<ImageView>(R.id.dataNilai)
        val btnAbsen = findViewById<ImageView>(R.id.dataAbsen)

        val btnHome = findViewById<LinearLayout>(R.id.btnHome)
        val btnAbout = findViewById<LinearLayout>(R.id.btnAbout)
        val btnProfilSekolah = findViewById<LinearLayout>(R.id.btnProfilSekolah)

        btnHome.setOnClickListener {
            val intent = Intent(this, HomeGuruActivity::class.java)
            startActivity(intent)
        }

        btnAbout.setOnClickListener {
            val intent = Intent(this, AboutSekolahActivity::class.java)
            startActivity(intent)
        }

        btnProfilSekolah.setOnClickListener {
            val intent = Intent(this, ProfilSekolahActivity::class.java)
            startActivity(intent)
        }
        btnNilai.setOnClickListener {
            val nama = intent.getStringExtra(RegisterGuruActivity.DATA_NAMA)
            val kelas = intent.getStringExtra(RegisterGuruActivity.DATA_KELAS)
            val intent = Intent(this, DataNilaiActivity::class.java)
                .putExtra(RegisterGuruActivity.DATA_NAMA, nama)
                .putExtra(RegisterGuruActivity.DATA_KELAS, kelas)
            startActivity(intent)
        }
        btnAbsen.setOnClickListener {
            val nama = intent.getStringExtra(RegisterGuruActivity.DATA_NAMA)
            val kelas = intent.getStringExtra(RegisterGuruActivity.DATA_KELAS)
            val intent = Intent(this, DataNilaiActivity::class.java)
                .putExtra(RegisterGuruActivity.DATA_NAMA, nama)
                .putExtra(RegisterGuruActivity.DATA_KELAS, kelas)
            startActivity(intent)
        }
        btnProfil.setOnClickListener {
            val nama = intent.getStringExtra(RegisterGuruActivity.DATA_NAMA)
            val nip = intent.getStringExtra(RegisterGuruActivity.DATA_NIP)
            val kelas = intent.getStringExtra(RegisterGuruActivity.DATA_KELAS)
            val jenisKelamin = intent.getStringExtra(RegisterGuruActivity.DATA_JK)
            val ttl = intent.getStringExtra(RegisterGuruActivity.DATA_TTL)
            val pass = intent.getStringExtra(RegisterGuruActivity.DATA_PASS)
            val intent = Intent(this, DataGuruActivity::class.java)
                .putExtra(RegisterGuruActivity.DATA_NAMA, nama)
                .putExtra(RegisterGuruActivity.DATA_NIP, nip)
                .putExtra(RegisterGuruActivity.DATA_KELAS, kelas)
                .putExtra(RegisterGuruActivity.DATA_JK, jenisKelamin)
                .putExtra(RegisterGuruActivity.DATA_TTL, ttl)
                .putExtra(RegisterGuruActivity.DATA_PASS, pass)
            startActivity(intent)
        }
    }
}