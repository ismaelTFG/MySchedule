package com.isma.myschedule.service

interface ValidationsService {
    fun date(date: String): Boolean
    fun time(time: String, total:Boolean): Boolean
    fun empty(task: String, date: String, hoursDay: String, totalHours: String,repeated: Boolean): Boolean
    fun topTime(hoursDay: String, totalHours: String): Boolean
}