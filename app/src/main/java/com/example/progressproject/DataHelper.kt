package com.example.progressproject

import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataHelper (context : Context?):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val session = "CREATE TABLE session(id integer, login text)"
        val sql =
            "CREATE TABLE siswa(id_user integer PRIMARY KEY AUTOINCREMENT, nama text NOT NULL, nisn integer NOT NULL, kelas text NOT NULL, jenis_kelamin text NOT NULL, ttl text NOT NULL, password text NOT NULL );"
        val insSession = "INSERT INTO session(id, login) VALUES(1,'Empty')"
        db.execSQL(session)
        db.execSQL(sql)
        db.execSQL(insSession)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS session")
        db.execSQL("DROP TABLE IF EXISTS siswa")
        onCreate(db)
    }

    fun checkSession(sessionValues: String): Boolean{
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM session WHERE login=?", arrayOf(sessionValues))
        return cursor.count>0
    }

    fun upgradeSession(sessionValues: String?, id: Int): Boolean{
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put("Login", sessionValues)
        val update = db.update("session", contentValues, "id=$id", null).toLong()
        return update != -1L
    }

    fun insertSiswa(nama: String?, nisn: String?, kelas: String?, jenis_kelamin: String?, ttl: String?, pass:String?): Boolean{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("nama", nama)
        contentValues.put("nisn", nisn)
        contentValues.put("kelas", kelas)
        contentValues.put("jenis_kelamin", jenis_kelamin)
        contentValues.put("ttl", ttl)
        contentValues.put("password", pass)
        val insert = db.insert("siswa", null, contentValues)
        return insert != -1L
    }
    fun checkLogin(nama: String, pass: String): Boolean {
        val db = this.readableDatabase
        val cursor =
            db.rawQuery("SELECT * FROM siswa WHERE nama = ? AND password = ?", arrayOf(nama, pass))
        return cursor.count>0
    }

    companion object {
        private const val DATABASE_NAME = "login.db"
        private const val DATABASE_VERSION = 1
    }
}