package com.isma.myschedule

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.isma.myschedule.service.impl.LanguageServiceImpl
import com.isma.myschedule.service.impl.TopicsServiceImpl

class MainActivity : ComponentActivity() {

    val languageService = LanguageServiceImpl(this)
    val topicsService = TopicsServiceImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity()
    }

    private fun mainActivity(){
        setContentView(R.layout.activity_main)
        val background = findViewById<ConstraintLayout>(R.id.main)
        val title = findViewById<TextView>(R.id.titleMain)
        val calendar = findViewById<Button>(R.id.calendarButton)
        val tasks = findViewById<Button>(R.id.tasksButton)
        val settingsButton = findViewById<Button>(R.id.settingsButton)
        background.setBackgroundColor(Color.parseColor(topicsService.topics("background")))
        title.setTextColor(Color.parseColor(topicsService.topics("content")))
        calendar.setText(languageService.language("calendar"))
        calendar.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        calendar.setTextColor(Color.parseColor(topicsService.topics("background")))
        tasks.setText(languageService.language("tasks"))
        tasks.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        tasks.setTextColor(Color.parseColor(topicsService.topics("background")))
        settingsButton.setText(languageService.language("settings"))
        settingsButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        settingsButton.setTextColor(Color.parseColor(topicsService.topics("background")))
        settingsButton.setOnClickListener {
            settingsActivity()
        }
    }

    private fun settingsActivity(){
        setContentView(R.layout.activity_settings)
        val background = findViewById<ConstraintLayout>(R.id.settings)
        val settingsText = findViewById<TextView>(R.id.settingsText)
        val language = findViewById<Button>(R.id.languageButton)
        val color = findViewById<Button>(R.id.colorButton)
        val exitSettings = findViewById<Button>(R.id.exitSettings)
        background.setBackgroundColor(Color.parseColor(topicsService.topics("background")))
        settingsText.setText(languageService.language("settings"))
        settingsText.setTextColor(Color.parseColor(topicsService.topics("content")))
        language.setText(languageService.language("language"))
        language.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        language.setTextColor(Color.parseColor(topicsService.topics("background")))
        color.setText(languageService.language("color"))
        color.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        color.setTextColor(Color.parseColor(topicsService.topics("background")))
        exitSettings.setText(languageService.language("exit"))
        exitSettings.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        exitSettings.setTextColor(Color.parseColor(topicsService.topics("background")))
        language.setOnClickListener {
            val dialogLayout = layoutInflater.inflate(R.layout.language, null)
            val spain = dialogLayout.findViewById<RadioButton>(R.id.spain)
            val english = dialogLayout.findViewById<RadioButton>(R.id.english)
            if ("spain" == languageService.selected()){
                spain.isChecked = true
            }
            if ("english" == languageService.selected()){
                english.isChecked = true
            }
            val builder = AlertDialog.Builder(this).setTitle(languageService.language("title_language")).setView(dialogLayout).setPositiveButton(languageService.language("change"), DialogInterface.OnClickListener { dialogInterface, i ->
                if (spain.isChecked){
                    languageService.update("spain")
                }
                if (english.isChecked){
                    languageService.update("english")
                }
                settingsActivity()
                dialogInterface.dismiss()
            }).setNegativeButton(languageService.language("not_change"), DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            }).create()
            builder.show()
        }
        color.setOnClickListener {
            val dialogLayout = layoutInflater.inflate(R.layout.topics, null)
            val light = dialogLayout.findViewById<RadioButton>(R.id.light)
            val dark = dialogLayout.findViewById<RadioButton>(R.id.dark)
            val blood = dialogLayout.findViewById<RadioButton>(R.id.blood)
            val cyan = dialogLayout.findViewById<RadioButton>(R.id.cyan)
            val plant = dialogLayout.findViewById<RadioButton>(R.id.plant)
            if ("light" == topicsService.selected()){
                light.isChecked = true
            }
            if ("dark" == topicsService.selected()){
                dark.isChecked = true
            }
            if ("blood" == topicsService.selected()){
                blood.isChecked = true
            }
            if ("cyan" == topicsService.selected()){
                cyan.isChecked = true
            }
            if ("plant" == topicsService.selected()){
                plant.isChecked = true
            }
            val builder = AlertDialog.Builder(this).setTitle(languageService.language("title_topics")).setView(dialogLayout).setPositiveButton(languageService.language("change"), DialogInterface.OnClickListener { dialogInterface, i ->
                if (light.isChecked){
                    topicsService.update("light")
                }
                if (dark.isChecked){
                    topicsService.update("dark")
                }
                if (blood.isChecked){
                    topicsService.update("blood")
                }
                if (cyan.isChecked){
                    topicsService.update("cyan")
                }
                if (plant.isChecked){
                    topicsService.update("plant")
                }
                settingsActivity()
                dialogInterface.dismiss()
            }).setNegativeButton(languageService.language("not_change"), DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            }).create()
            builder.show()
        }
        exitSettings.setOnClickListener {
            mainActivity()
        }
    }
}