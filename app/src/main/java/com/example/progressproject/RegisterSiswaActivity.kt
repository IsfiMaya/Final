package com.example.progressproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterSiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_siswa)
        val db = DataHelper(this)
        val nama = findViewById<EditText>(R.id.edtNama)
        val pass = findViewById<EditText>(R.id.edtPass)
        val nisn = findViewById<EditText>(R.id.edtNisn)
        val kelas = findViewById<EditText>(R.id.edtKelas)
        val jenisKelamin = findViewById<EditText>(R.id.edtJenisKelamin)
        val ttl = findViewById<EditText>(R.id.edtTtl)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            val strNama = nama.text.toString()
            val strPass = pass.text.toString()
            val strNisn = nisn.text.toString()
            val strTtl = ttl.text.toString()
            val strJK = jenisKelamin.text.toString()
            val strKelas = kelas.text.toString()

            val daftar = db.insertSiswa(strNama, strNisn, strKelas, strJK, strTtl, strPass)
            if(daftar){
                if(nama.text.toString().isEmpty()){
                    nama.error = "Nama diperlukan!"
                }else if(pass.text.toString().isEmpty()){
                    pass.error = "Password diperlukan!"
                }else{
                    Toast.makeText(applicationContext, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginSiswaActivity::class.java)
                        .putExtra(DATA_NAMA, strNama)
                        .putExtra(DATA_NISN, strNisn)
                        .putExtra(DATA_KELAS, strKelas)
                        .putExtra(DATA_JK, strJK)
                        .putExtra(DATA_TTL, strTtl)
                        .putExtra(DATA_PASS, strPass)
                    startActivity(intent)
                    finish()
                }
            }else{
                Toast.makeText(applicationContext, "Gagal Mendaftar", Toast.LENGTH_SHORT).show()
            }
        }

    }
    companion object{
        const val DATA_NAMA = "DATA_NAMA"
        const val DATA_NISN = "DATA_NISN"
        const val DATA_KELAS = "DATA_KELAS"
        const val DATA_JK = "DATA_JK"
        const val DATA_TTL = "DATA_TTL"
        const val DATA_PASS = "DATA_PASS"
    }
}