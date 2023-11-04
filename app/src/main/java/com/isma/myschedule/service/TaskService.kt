package com.isma.myschedule.service

import com.isma.myschedule.entity.Task

interface TaskService {
    fun add(task: Task)
    fun listAll(): ArrayList<Task>
    fun findByID(id: Int): Task
    fun update(task: Task)
}