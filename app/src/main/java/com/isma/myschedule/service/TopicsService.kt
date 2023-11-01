package com.isma.myschedule.service

interface TopicsService {
    fun topics(text: String): String
    fun selected(): String
    fun update(topics: String)
}