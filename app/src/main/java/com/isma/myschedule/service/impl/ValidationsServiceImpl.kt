package com.isma.myschedule.service.impl

import android.content.Context
import com.isma.myschedule.service.ValidationsService
import java.time.LocalDateTime
import java.util.GregorianCalendar

class ValidationsServiceImpl(): ValidationsService {

    override fun date(date: String): Boolean {
        if (date == "Fecha de inicio" || date == "Start date"){
            return true
        }
        val splitDate = date.split("/")
        val now = LocalDateTime.now()
        if (splitDate.size == 3){
            splitDate.forEach {
                if (it == "." || it == "-" || it == ""){
                    return false
                }
            }
            val year = splitDate[2].toInt()
            if (year >= now.year && year < 10000){
                val month = splitDate[1].toInt()
                if (month in 1..12){
                    if (year == now.year){
                        if (month < now.monthValue){
                            return false
                        }
                    }
                    val day = splitDate[0].toInt()
                    if (day < 1){
                        return false
                    }
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                        if (day > 31){
                            return false
                        }
                    }
                    if (month == 4 || month == 6 || month == 9 || month == 11){
                        if (day > 30){
                            return false
                        }
                    }
                    if (GregorianCalendar().isLeapYear(year)){
                        if (month == 2 && day > 29){
                            return false
                        }
                    }else{
                        if (month == 2 && day > 28){
                            return false
                        }
                    }
                    if (month == now.monthValue && year == now.year){
                        if (day > now.dayOfMonth){
                            return true
                        }
                    }else{
                        return true
                    }
                }
            }
        }else if (splitDate[0] == "" && date != "/"){
            return true
        }
        return false
    }

    override fun time(time: String, total: Boolean): Boolean {
        val splitTime = time.split(":")
        if (splitTime.size <= 2){
            splitTime.forEach {
                if (!total && it == ""){
                    return false
                }
            }
            if (!total && splitTime[0].toInt() > 24){
                return false
            }
            if (splitTime.size > 1){
                if (!total && splitTime[0].toInt() == 24){
                    if (splitTime[1].toInt() > 0){
                        return false
                    }
                }
                if (splitTime[1].toInt() > 59){
                    return false
                }
            }
            return true
        }
        return false
    }

    override fun empty(task: String, date: String, hoursDay: String, totalHours: String,repeated: Boolean): Boolean {
        if (task != ""){
            if (hoursDay != ""){
                if (repeated){
                    return true
                }
                if (date != ""){
                    if (totalHours != ""){
                        return true
                    }
                }
            }
        }
        return false
    }

    override fun topTime(hoursDay: String, totalHours: String): Boolean {
        if (totalHours == "Horas totales" || totalHours == "total hours"){
            return true
        }
        val splitHoursDay = hoursDay.split(":")
        val splitTotalHours = totalHours.split(":")
        if (totalHours == ""){
            return true
        }
        if (splitTotalHours[0].toInt() < splitHoursDay[0].toInt()){
            return false
        }
        if (splitTotalHours.size < 2 || splitHoursDay.size < 2){
            return true
        }
        if (splitTotalHours[0].toInt() == splitHoursDay[0].toInt()){
            if (splitTotalHours[1].toInt() < splitHoursDay[1].toInt()){
                return false
            }
        }
        return true
    }
}