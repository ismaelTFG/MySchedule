package com.isma.myschedule.service.impl

import android.content.Context
import com.isma.myschedule.entity.Task
import com.isma.myschedule.repository.Sqlite
import com.isma.myschedule.service.TaskService

class TaskServiceImpl(context: Context): TaskService {

    private val sqlite = Sqlite(context)

    override fun add(task: Task) {
        sqlite.addTask(sqlite.writableDatabase, task)
    }

    override fun listAll(): ArrayList<Task> {
        return sqlite.listAllTask(sqlite.writableDatabase)
    }

    override fun findByID(id: Int): Task {
        return sqlite.findByIdTask(sqlite.writableDatabase, id)
    }

    override fun update(task: Task) {
        return sqlite.updateTask(sqlite.writableDatabase, task)
    }
}