package com.example.progressproject

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DataSiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_siswa)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        val nama = intent.getStringExtra(LoginSiswaActivity.DATA_NAMA)
        val db = DataHelper(this)
        val namaSiswa = findViewById<TextView>(R.id.tvNamaSiswa)
        val nisnSiswa = findViewById<TextView>(R.id.tvNISN)
        val kelasSiswa = findViewById<TextView>(R.id.tvKelas)
        val jkSiswa = findViewById<TextView>(R.id.tvJK)
        val ttlSiswa = findViewById<TextView>(R.id.tvTTL)
        val cursor : Cursor
        var namaDua : String = ""
        val database = db.readableDatabase
        cursor = database.rawQuery("SELECT * FROM siswa WHERE nama = '$nama'", null)
        cursor.moveToFirst()
        if (cursor.count > 0) {
            cursor.moveToPosition(0)
            namaSiswa.text = cursor.getString(1).toString()
            nisnSiswa.text = cursor.getString(2).toString()
            kelasSiswa.text = cursor.getString(3).toString()
            jkSiswa.text = cursor.getString(4).toString()
            ttlSiswa.text = cursor.getString(5).toString()
            namaDua = cursor.getString(1).toString()
        }

        val checkSession = db.checkSession("Empty")
        if(checkSession){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnKembali.setOnClickListener {
            val intent = Intent(this, HomeSiswaActivity::class.java)
            startActivity(intent)
        }
    }
}