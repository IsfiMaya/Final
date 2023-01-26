package com.example.progressproject

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DataAbsenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_absen)
        val nama = intent.getStringExtra(LoginGuruActivity.DATA_NAMA)
        val db = DataHelperGuru(this)
        val btnKembali = findViewById<ImageView>(R.id.btnKembali)
        val namaGuru = findViewById<TextView>(R.id.tvNamaGuru)
        val kelasGuru = findViewById<TextView>(R.id.tvKelasMengajar)
        val cursor : Cursor
        var namaDua : String = ""
        val database = db.readableDatabase
        cursor = database.rawQuery("SELECT * FROM guru WHERE nama = '$nama'", null)
        cursor.moveToFirst()
        if (cursor.count > 0) {
            cursor.moveToPosition(0)
            namaGuru.text = cursor.getString(1).toString()
            kelasGuru.text = cursor.getString(3).toString()
            namaDua = cursor.getString(1).toString()
        }
        val checkSession = db.checkSession("Empty")
        if(checkSession){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnKembali.setOnClickListener {
            val intent = Intent(this, HomeGuruActivity::class.java)
            startActivity(intent)
        }
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
    }
}