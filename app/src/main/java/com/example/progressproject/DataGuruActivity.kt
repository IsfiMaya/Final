package com.example.progressproject

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DataGuruActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_guru)
        val btnKembali = findViewById<Button>(R.id.btnKembali)
        val nama = intent.getStringExtra(LoginGuruActivity.DATA_NAMA)
        val db = DataHelperGuru(this)
        val namaGuru = findViewById<TextView>(R.id.tvNamaGuru)
        val nipGuru = findViewById<TextView>(R.id.tvNip)
        val kelasGuru = findViewById<TextView>(R.id.tvKelas)
        val jkGuru = findViewById<TextView>(R.id.tvJenisKelamin)
        val ttlGuru = findViewById<TextView>(R.id.tvTtl)
        val cursor : Cursor
        var namaDua : String = ""
        val database = db.readableDatabase
        cursor = database.rawQuery("SELECT * FROM guru WHERE nama = '$nama'", null)
        cursor.moveToFirst()
        if (cursor.count > 0) {
            cursor.moveToPosition(0)
            namaGuru.text = cursor.getString(1).toString()
            nipGuru.text = cursor.getString(2).toString()
            kelasGuru.text = cursor.getString(3).toString()
            jkGuru.text = cursor.getString(4).toString()
            ttlGuru.text = cursor.getString(5).toString()
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
    }
}