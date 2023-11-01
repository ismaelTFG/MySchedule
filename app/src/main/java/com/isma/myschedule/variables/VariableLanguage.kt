package com.isma.myschedule.variables

import com.isma.myschedule.R

class VariableLanguage {
    fun language(language: String, type: String): Int{
        when(language){
            "spain" -> {
                when(type) {
                    "calendar" -> {
                        return R.string.calendar_spain
                    }
                    "tasks" -> {
                        return R.string.tasks_spain
                    }
                    "settings" -> {
                        return R.string.settings_spain
                    }
                    "language" -> {
                        return R.string.language_spain
                    }
                    "color" -> {
                        return R.string.color_spain
                    }
                    "exit" -> {
                        return R.string.exit_spain
                    }
                    "title_language" -> {
                        return R.string.title_language_spain
                    }
                    "title_topics" -> {
                        return R.string.title_topics_spain
                    }
                    "change" -> {
                        return R.string.change_spain
                    }
                    "not_change" -> {
                        return R.string.not_change_spain
                    }
                }
            }
            "english" ->{
                when(type) {
                    "calendar" -> {
                        return R.string.calendar_english
                    }
                    "tasks" -> {
                        return R.string.tasks_english
                    }
                    "settings" -> {
                        return R.string.settings_english
                    }
                    "language" -> {
                        return R.string.language_english
                    }
                    "color" -> {
                        return R.string.color_english
                    }
                    "exit" -> {
                        return R.string.exit_english
                    }
                    "title_language" -> {
                        return R.string.title_language_english
                    }
                    "title_topics" -> {
                        return R.string.title_topics_english
                    }
                    "change" -> {
                        return R.string.change_english
                    }
                    "not_change" -> {
                        return R.string.not_change_english
                    }
                }
            }
        }
        return 0
    }
}