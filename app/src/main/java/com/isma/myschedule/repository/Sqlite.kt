package com.isma.myschedule.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.isma.myschedule.entity.Task

class Sqlite(context: Context):SQLiteOpenHelper(context, "myschedule", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE language ( id INTEGER PRIMARY KEY, language TEXT)")
        db.execSQL("CREATE TABLE topics ( id INTEGER PRIMARY KEY, topics TEXT)")
        db.execSQL("CREATE TABLE task (id INTEGER PRIMARY KEY, task TEXT, date TEXT, hours_day TEXT, total_hours TEXT, priority INTEGER)")
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

    fun listAllTask(db: SQLiteDatabase): ArrayList<Task>{
        val result = db.rawQuery("SELECT * FROM task", null)
        val list = ArrayList<Task>()
        if (result!!.moveToFirst()){
            while (!result.isAfterLast){
                list.add(Task(result.getInt(0), result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5) == 1))
                result.moveToNext()
            }
        }
        return list
    }

    fun findByIdTask(db: SQLiteDatabase, id: Int): Task{
        val result = db.rawQuery("SELECT * FROM task WHERE id=$id", null)
        if (result!!.moveToFirst()){
            return Task(result.getInt(0), result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5) == 1)
        }
        return Task(0, "", "", "", "", false)
    }

    fun addTask(db: SQLiteDatabase, task: Task){
        val add = ContentValues()
        add.put("id", task.id)
        add.put("task", task.task)
        add.put("date", task.date)
        add.put("hours_day", task.hoursDay)
        add.put("total_hours", task.totalhours)
        add.put("priority", if (task.priority) 1 else 0)
        db.insert("task", null, add)
    }

    fun updateTask(db: SQLiteDatabase, task: Task){
        val add = ContentValues()
        add.put("task", task.task)
        add.put("date", task.date)
        add.put("hours_day", task.hoursDay)
        add.put("total_hours", task.totalhours)
        add.put("priority", if (task.priority) 1 else 0)
        db.update("task", add, "id=${task.id}", null)
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