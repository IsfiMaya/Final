package com.example.progressproject

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class HomeSiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_siswa)
        val btnProfil = findViewById<ImageView>(R.id.imgViewProfil)
        val btnSiswa = findViewById<ImageView>(R.id.imageViewSiswa)
        val btnKelas = findViewById<ImageView>(R.id.imageViewKelas)
        val btnJadwal = findViewById<ImageView>(R.id.imageViewJadwal)
        val btnJurusan = findViewById<ImageView>(R.id.imageViewJurusan)
        val btnMapel = findViewById<ImageView>(R.id.imageViewMataPelajaran)
        val btnHome = findViewById<LinearLayout>(R.id.btnHome)
        val btnAbout = findViewById<LinearLayout>(R.id.btnAbout)
        val btnProfilSekolah = findViewById<LinearLayout>(R.id.btnProfilSekolah)

        btnHome.setOnClickListener {
            val intent = Intent(this, HomeSiswaActivity::class.java)
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

        btnProfil.setOnClickListener {
            val nama = intent.getStringExtra(RegisterSiswaActivity.DATA_NAMA)
            val pass = intent.getStringExtra(RegisterSiswaActivity.DATA_PASS)
            val nisn = intent.getStringExtra(RegisterSiswaActivity.DATA_NISN)
            val kelas = intent.getStringExtra(RegisterSiswaActivity.DATA_KELAS)
            val jenisKelamin = intent.getStringExtra(RegisterSiswaActivity.DATA_JK)
            val ttl = intent.getStringExtra(RegisterSiswaActivity.DATA_TTL)
            val intent = Intent(this, DataSiswaActivity::class.java)
                .putExtra(RegisterSiswaActivity.DATA_NAMA, nama)
                .putExtra(RegisterSiswaActivity.DATA_PASS, pass)
                .putExtra(RegisterSiswaActivity.DATA_NISN, nisn)
                .putExtra(RegisterSiswaActivity.DATA_KELAS, kelas)
                .putExtra(RegisterSiswaActivity.DATA_JK, jenisKelamin)
                .putExtra(RegisterSiswaActivity.DATA_TTL, ttl)
            startActivity(intent)
        }
        btnSiswa.setOnClickListener {
            val nama = intent.getStringExtra(RegisterSiswaActivity.DATA_NAMA)
            val pass = intent.getStringExtra(RegisterSiswaActivity.DATA_PASS)
            val nisn = intent.getStringExtra(RegisterSiswaActivity.DATA_NISN)
            val kelas = intent.getStringExtra(RegisterSiswaActivity.DATA_KELAS)
            val jenisKelamin = intent.getStringExtra(RegisterSiswaActivity.DATA_JK)
            val ttl = intent.getStringExtra(RegisterSiswaActivity.DATA_TTL)
            val intent = Intent(this, DataSiswaActivity::class.java)
                .putExtra(RegisterSiswaActivity.DATA_NAMA, nama)
                .putExtra(RegisterSiswaActivity.DATA_PASS, pass)
                .putExtra(RegisterSiswaActivity.DATA_NISN, nisn)
                .putExtra(RegisterSiswaActivity.DATA_KELAS, kelas)
                .putExtra(RegisterSiswaActivity.DATA_JK, jenisKelamin)
                .putExtra(RegisterSiswaActivity.DATA_TTL, ttl)
            startActivity(intent)
        }
        btnKelas.setOnClickListener {
            val intent = Intent(this, KelasActivity::class.java)
            startActivity(intent)
        }
        btnJadwal.setOnClickListener {
            val intent = Intent(this, JadwalActivity::class.java)
            startActivity(intent)
        }
        btnJurusan.setOnClickListener {
            val intent = Intent(this, JurusanActivity::class.java)
            startActivity(intent)
        }
        btnMapel.setOnClickListener {
            val intent = Intent(this, MataPelajaranActivity::class.java)
            startActivity(intent)
        }
    }
}