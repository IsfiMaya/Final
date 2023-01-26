package com.example.progressproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginGuruActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_guru)
        val db = DataHelperGuru(this)
        val nama = findViewById<EditText>(R.id.edtEmail)
        val pass = findViewById<EditText>(R.id.edtPass)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)
        btnLogin.setOnClickListener {
            val strNama = nama.text.toString()
            val strPass = pass.text.toString()
            val masuk = db.checkLoginGuru(strNama, strPass)
            if(masuk){
                val updateSession = db.upgradeSession("ada", 1)
                if(updateSession){
                    Toast.makeText(applicationContext, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeGuruActivity::class.java).putExtra(
                        DATA_NAMA, strNama
                    ).putExtra(DATA_PASS, strPass)
                    startActivity(intent)
                }
            }else{
                Toast.makeText(
                    applicationContext,
                    "Nama atau Password Salah",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    companion object{
        const val DATA_NAMA = "DATA_NAMA"
        const val DATA_PASS = "DATA_PASS"
    }
}