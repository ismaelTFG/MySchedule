package com.isma.myschedule.service.impl

import android.content.Context
import com.isma.myschedule.repository.Sqlite
import com.isma.myschedule.service.TopicsService
import com.isma.myschedule.variables.VariableTopics

class TopicsServiceImpl(context: Context): TopicsService {

    private val sqlite = Sqlite(context)
    private val variableTopics = VariableTopics()

    override fun topics(type: String): String {
        return variableTopics.topics(selected(), type)
    }

    override fun selected(): String {
        return sqlite.topics(sqlite.writableDatabase)
    }

    override fun update(topics: String) {
        sqlite.updateTopics(sqlite.writableDatabase, topics)
    }
}