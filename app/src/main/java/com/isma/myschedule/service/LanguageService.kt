package com.isma.myschedule.service

interface LanguageService{
    fun language(text: String): Int
    fun selected(): String
    fun update(language: String)
}