package com.isma.myschedule.service.impl

import android.content.Context
import com.isma.myschedule.repository.Sqlite
import com.isma.myschedule.service.LanguageService
import com.isma.myschedule.variables.VariableLanguage

class LanguageServiceImpl(context: Context): LanguageService {

    private val sqlite = Sqlite(context)
    private val variableLanguage = VariableLanguage()

    override fun language(text: String): Int {
        return variableLanguage.language(selected(),text)
    }

    override fun selected(): String {
        return sqlite.language(sqlite.writableDatabase)
    }

    override fun update(language: String) {
        sqlite.updateLanguage(sqlite.writableDatabase, language)
    }
}