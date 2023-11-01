package com.isma.myschedule.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Sqlite(context: Context):SQLiteOpenHelper(context, "myschedule", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE language ( id INTEGER PRIMARY KEY, language TEXT)")
        db.execSQL("CREATE TABLE topics ( id INTEGER PRIMARY KEY, topics TEXT)")
        defaultLanguage(db)
        defaultTopics(db)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun language(db: SQLiteDatabase): String{
        val result = db.rawQuery("SELECT * FROM language", null)
        if (result!!.moveToFirst()){
            return result.getString(1)
        }
        return "spain"
    }

    fun updateLanguage(db: SQLiteDatabase, language: String){
        val add = ContentValues()
        add.put("language", language)
        db.update("language", add, "id=1", null)
    }

    fun topics(db: SQLiteDatabase): String{
        val result = db.rawQuery("SELECT * FROM topics", null)
        if (result!!.moveToFirst()){
            return result.getString(1)
        }
        return "light"
    }

    fun updateTopics(db: SQLiteDatabase, topics: String){
        val add = ContentValues()
        add.put("topics", topics)
        db.update("topics", add, "id=1", null)
    }

    private fun defaultLanguage(db: SQLiteDatabase){
        val add = ContentValues()
        add.put("id", 1)
        add.put("language", "spain")
        db.insert("language", null, add)
    }

    private fun defaultTopics(db: SQLiteDatabase){
        val add = ContentValues()
        add.put("id", 1)
        add.put("topics", "light")
        db.insert("topics", null, add)
    }
}