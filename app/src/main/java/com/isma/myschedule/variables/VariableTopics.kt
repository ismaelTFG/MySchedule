package com.isma.myschedule.variables

import com.isma.myschedule.R

class VariableTopics {
    fun topics(topics: String, type: String): String{
        when(topics){
            "dark" -> {
                when(type){
                    "background" -> {
                        return "#17202A"
                    }
                    "content" -> {
                        return "#E5E8E8"
                    }
                }
            }
            "light" -> {
                when(type){
                    "background" -> {
                        return "#E5E8E8"
                    }
                    "content" -> {
                        return "#17202A"
                    }
                }
            }
            "blood" -> {
                when(type){
                    "background" -> {
                        return "#E81010"
                    }
                    "content" -> {
                        return "#4B1C1C"
                    }
                }
            }
            "cyan" -> {
                when(type){
                    "background" -> {
                        return "#81FAED"
                    }
                    "content" -> {
                        return "#2C4341"
                    }
                }
            }
            "plant" -> {
                when(type){
                    "background" -> {
                        return "#5DE834"
                    }
                    "content" -> {
                        return "#395431"
                    }
                }
            }
        }
        return ""
    }
}