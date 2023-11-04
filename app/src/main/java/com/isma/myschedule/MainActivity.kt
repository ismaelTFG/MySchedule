package com.isma.myschedule

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.isma.myschedule.entity.Task
import com.isma.myschedule.service.impl.LanguageServiceImpl
import com.isma.myschedule.service.impl.TaskServiceImpl
import com.isma.myschedule.service.impl.TopicsServiceImpl
import com.isma.myschedule.service.impl.ValidationsServiceImpl

class MainActivity : ComponentActivity() {

    private val languageService = LanguageServiceImpl(this)
    private val topicsService = TopicsServiceImpl(this)
    private val taskService = TaskServiceImpl(this)
    private val validationsService = ValidationsServiceImpl()

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
        tasks.setOnClickListener {
            tasksActivity()
        }
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

    private fun tasksActivity(){
        setContentView(R.layout.activity_tasks)
        val background = findViewById<ConstraintLayout>(R.id.tasks)
        val title = findViewById<TextView>(R.id.tasksText)
        val content = findViewById<LinearLayout>(R.id.content)
        val add = findViewById<Button>(R.id.addTasks)
        val exit = findViewById<Button>(R.id.exitTasks)
        background.setBackgroundColor(Color.parseColor(topicsService.topics("background")))
        title.setText(languageService.language("tasks"))
        title.setTextColor(Color.parseColor(topicsService.topics("content")))
        add.setText(languageService.language("add"))
        add.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        add.setTextColor(Color.parseColor(topicsService.topics("background")))
        exit.setText(languageService.language("exit"))
        exit.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        exit.setTextColor(Color.parseColor(topicsService.topics("background")))
        content(content)
        add.setOnClickListener {
            addActivity()
        }
        exit.setOnClickListener {
            mainActivity()
        }
    }

    private fun addActivity(){
        setContentView(R.layout.activity_add)
        val background = findViewById<ConstraintLayout>(R.id.add)
        val task = findViewById<EditText>(R.id.task)
        val date = findViewById<EditText>(R.id.date)
        val hoursDay = findViewById<EditText>(R.id.hoursDay)
        val totalHours = findViewById<EditText>(R.id.totalDay)
        val repeated = findViewById<CheckBox>(R.id.repeated)
        val priority = findViewById<CheckBox>(R.id.priority)
        val add = findViewById<Button>(R.id.addAdd)
        val exit = findViewById<Button>(R.id.exitAdd)
        background.setBackgroundColor(Color.parseColor(topicsService.topics("background")))
        task.setHint(languageService.language("task"))
        task.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        task.setTextColor(Color.parseColor(topicsService.topics("content")))
        task.setHintTextColor(Color.parseColor(topicsService.topics("content")))
        date.setHint(languageService.language("date"))
        date.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        date.setTextColor(Color.parseColor(topicsService.topics("content")))
        date.setHintTextColor(Color.parseColor(topicsService.topics("content")))
        hoursDay.setHint(languageService.language("hours_day"))
        hoursDay.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        hoursDay.setTextColor(Color.parseColor(topicsService.topics("content")))
        hoursDay.setHintTextColor(Color.parseColor(topicsService.topics("content")))
        totalHours.setHint(languageService.language("total_hours"))
        totalHours.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        totalHours.setTextColor(Color.parseColor(topicsService.topics("content")))
        totalHours.setHintTextColor(Color.parseColor(topicsService.topics("content")))
        repeated.setText(languageService.language("repeated"))
        repeated.buttonTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        repeated.setTextColor(Color.parseColor(topicsService.topics("content")))
        priority.setText(languageService.language("priority"))
        priority.buttonTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        priority.setTextColor(Color.parseColor(topicsService.topics("content")))
        add.setText(languageService.language("add"))
        add.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        add.setTextColor(Color.parseColor(topicsService.topics("background")))
        exit.setText(languageService.language("exit"))
        exit.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        exit.setTextColor(Color.parseColor(topicsService.topics("background")))
        repeated.setOnClickListener {
            if (repeated.isChecked){
                date.visibility = View.GONE
                totalHours.visibility = View.GONE
            }else{
                date.visibility = View.VISIBLE
                totalHours.visibility = View.VISIBLE
            }
        }
        add.setOnClickListener {
            add(task.text.toString(), date.text.toString(), hoursDay.text.toString(), totalHours.text.toString(), repeated.isChecked, priority.isChecked)
        }
        exit.setOnClickListener {
            tasksActivity()
        }
    }

    private fun updateActivity(id: Int){
        setContentView(R.layout.activity_add)
        val background = findViewById<ConstraintLayout>(R.id.add)
        val task = findViewById<EditText>(R.id.task)
        val date = findViewById<EditText>(R.id.date)
        val hoursDay = findViewById<EditText>(R.id.hoursDay)
        val totalHours = findViewById<EditText>(R.id.totalDay)
        val repeated = findViewById<CheckBox>(R.id.repeated)
        val priority = findViewById<CheckBox>(R.id.priority)
        val add = findViewById<Button>(R.id.addAdd)
        val exit = findViewById<Button>(R.id.exitAdd)
        val taskEntity = taskService.findByID(id)
        background.setBackgroundColor(Color.parseColor(topicsService.topics("background")))
        task.hint = taskEntity.task
        task.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        task.setTextColor(Color.parseColor(topicsService.topics("content")))
        task.setHintTextColor(Color.parseColor(topicsService.topics("content")))
        date.hint = taskEntity.date
        date.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        date.setTextColor(Color.parseColor(topicsService.topics("content")))
        date.setHintTextColor(Color.parseColor(topicsService.topics("content")))
        hoursDay.hint = taskEntity.hoursDay
        hoursDay.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        hoursDay.setTextColor(Color.parseColor(topicsService.topics("content")))
        hoursDay.setHintTextColor(Color.parseColor(topicsService.topics("content")))
        totalHours.hint = taskEntity.totalhours
        totalHours.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        totalHours.setTextColor(Color.parseColor(topicsService.topics("content")))
        totalHours.setHintTextColor(Color.parseColor(topicsService.topics("content")))
        if (taskEntity.date == "" && taskEntity.totalhours == ""){
            repeated.isChecked = true
            date.visibility = View.GONE
            totalHours.visibility = View.GONE
            date.setHint(languageService.language("date"))
            totalHours.setHint(languageService.language("total_hours"))
        }
        repeated.setText(languageService.language("repeated"))
        repeated.buttonTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        repeated.setTextColor(Color.parseColor(topicsService.topics("content")))
        priority.isChecked = taskEntity.priority
        priority.setText(languageService.language("priority"))
        priority.buttonTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        priority.setTextColor(Color.parseColor(topicsService.topics("content")))
        add.setText(languageService.language("update"))
        add.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        add.setTextColor(Color.parseColor(topicsService.topics("background")))
        exit.setText(languageService.language("exit"))
        exit.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
        exit.setTextColor(Color.parseColor(topicsService.topics("background")))
        repeated.setOnClickListener {
            if (repeated.isChecked){
                date.visibility = View.GONE
                totalHours.visibility = View.GONE
            }else{
                date.visibility = View.VISIBLE
                totalHours.visibility = View.VISIBLE
            }
        }
        add.setOnClickListener {
            var textTask = task.text.toString()
            var textDate = date.text.toString()
            var textDay = hoursDay.text.toString()
            var textTotal = totalHours.text.toString()
            if (textTask == ""){
                textTask = task.hint.toString()
            }
            if (textDate == ""){
                textDate = date.hint.toString()
            }
            if (textDay == ""){
                textDay = hoursDay.hint.toString()
            }
            if (textTotal == ""){
                textTotal = totalHours.hint.toString()
            }
            update(id, textTask, textDate, textDay, textTotal, repeated.isChecked, priority.isChecked)
        }
        exit.setOnClickListener {
            tasksActivity()
        }
    }

    private fun content(view: LinearLayout){
        val list = taskService.listAll()
        list.forEach { i ->
            val layout = layoutInflater.inflate(R.layout.task, null)
            val background = layout.findViewById<LinearLayout>(R.id.taskBackground)
            val task = layout.findViewById<TextView>(R.id.listTask)
            val date = layout.findViewById<TextView>(R.id.listDate)
            val hoursDay = layout.findViewById<TextView>(R.id.listHoursDay)
            val totalHours = layout.findViewById<TextView>(R.id.listTotalHours)
            val priority = layout.findViewById<TextView>(R.id.listPriority)
            val update = layout.findViewById<Button>(R.id.update)
            background.setBackgroundColor(Color.parseColor(topicsService.topics("background")))
            task.setTextColor(Color.parseColor(topicsService.topics("content")))
            date.setTextColor(Color.parseColor(topicsService.topics("content")))
            hoursDay.setTextColor(Color.parseColor(topicsService.topics("content")))
            totalHours.setTextColor(Color.parseColor(topicsService.topics("content")))
            priority.setTextColor(Color.parseColor(topicsService.topics("content")))
            update.setText(languageService.language("update"))
            update.backgroundTintList = ColorStateList.valueOf(Color.parseColor(topicsService.topics("content")))
            update.setTextColor(Color.parseColor(topicsService.topics("background")))
            task.text = i.task
            date.text = i.date
            hoursDay.text = i.hoursDay
            totalHours.text = i.totalhours
            if (i.priority){
                priority.setText(languageService.language("priority_text"))
            }else{
                priority.setText(languageService.language("not_priority"))
            }
            update.setOnClickListener {
                updateActivity(i.id)
            }
            view.addView(layout)
        }
    }

    private fun add(task: String, date: String, hoursDay: String, totalHours: String,repeated: Boolean, priority: Boolean){
        if (validationsService.empty(task, date, hoursDay, totalHours, repeated)){
            if (validationsService.date(date)){
                if (validationsService.time(hoursDay, false) && validationsService.time(totalHours, true)){
                    if (validationsService.topTime(hoursDay, totalHours)){
                        val list = taskService.listAll()
                        var id = 1
                        if (list.size > 0){
                            id = list[list.size-1].id + 1
                        }
                        if (repeated){
                            taskService.add(Task(id, task, "", hoursDay, "", priority))
                        }else{
                            taskService.add(Task(id, task, date, hoursDay, totalHours, priority))
                        }
                        tasksActivity()
                    }else{
                        Toast.makeText(this, languageService.language("top_time"), Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this, languageService.language("error_time"), Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, languageService.language("error_date"), Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, languageService.language("empty"), Toast.LENGTH_LONG).show()
        }
    }

    private fun update(id: Int, task: String, date: String, hoursDay: String, totalHours: String,repeated: Boolean, priority: Boolean){
        if (validationsService.empty(task, date, hoursDay, totalHours, repeated)){
            if (validationsService.date(date)){
                if (validationsService.time(hoursDay, false) && validationsService.time(totalHours, true)){
                    if (validationsService.topTime(hoursDay, totalHours)){
                        if (repeated){
                            taskService.update(Task(id, task, "", hoursDay, "", priority))
                        }else{
                            taskService.update(Task(id, task, date, hoursDay, totalHours, priority))
                        }
                        tasksActivity()
                    }else{
                        Toast.makeText(this, languageService.language("top_time"), Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this, languageService.language("error_time"), Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, languageService.language("error_date"), Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, languageService.language("empty"), Toast.LENGTH_LONG).show()
        }
    }
}