package com.isma.myschedule.variables

import com.isma.myschedule.R

class VariableLanguage {
    fun language(language: String, type: String): Int{
        when(language)  {
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
                    "add" -> {
                        return R.string.add_spain
                    }
                    "task" -> {
                        return R.string.task_spain
                    }
                    "date" -> {
                        return R.string.date_spain
                    }
                    "hours_day" -> {
                        return R.string.hours_day_spain
                    }
                    "total_hours" -> {
                        return R.string.total_hours_spain
                    }
                    "repeated" -> {
                        return R.string.repeated_spain
                    }
                    "priority" -> {
                        return R.string.priority_spain
                    }
                    "error_date" -> {
                        return R.string.error_date_spain
                    }
                    "error_time" -> {
                        return R.string.error_time_spain
                    }
                    "empty" -> {
                        return R.string.empty_spain
                    }
                    "priority_text" -> {
                        return R.string.priority_text_spain
                    }
                    "not_priority" -> {
                        return R.string.not_priority_spain
                    }
                    "update" -> {
                        return R.string.update_spain
                    }
                    "top_time" -> {
                        return R.string.top_time_spain
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
                    "add" -> {
                        return R.string.add_english
                    }
                    "task" -> {
                        return R.string.task_english
                    }
                    "date" -> {
                        return R.string.date_english
                    }
                    "hours_day" -> {
                        return R.string.hours_day_english
                    }
                    "total_hours" -> {
                        return R.string.total_hours_english
                    }
                    "repeated" -> {
                        return R.string.repeated_english
                    }
                    "priority" -> {
                        return R.string.priority_english
                    }
                    "error_date" -> {
                        return R.string.error_date_english
                    }
                    "error_time" -> {
                        return R.string.error_time_english
                    }
                    "empty" -> {
                        return R.string.empty_english
                    }
                    "priority_text" -> {
                        return R.string.priority_text_english
                    }
                    "not_priority" -> {
                        return R.string.not_priority_english
                    }
                    "update" -> {
                        return R.string.update_english
                    }
                    "top_time" -> {
                        return R.string.top_time_english
                    }
                }
            }
        }
        return 0
    }
}