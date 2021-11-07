package com.example.freelance_app.view.screens

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "User"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    //SharedPreferences variables: (we have only one)
    private val APP_MODE = Pair("mode", "")
    private val JOB = Pair(
        "job", "Washes all wares including pots, plans, flatware, " +
                "and glasses, by hand or using dishwashers. Correctly " +
                "places and stores clean equipment, dishes, and utensils" +
                " in assigned storage areas. ... May assist in cleaning " +
                "and preparing various foods " +
                "for cooking and/or serving, as directed. "
    )
    private val SKILLS = Pair(
        "skills", "-> Manual dexterity\n" +
                "-> Ability to keep kitchen clean and tidy\n" +
                "-> Reliability, professionalism and keen sense of cleanliness\n" +
                "-> Organizational skills\n" +
                "-> Flexibility and willingness to work shifts\n" +
                "-> Physical strength and stamina"
    )
    private val DATES = Pair(
        "dates", "Nov 5 - Nov 6, 2021"
    )

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var mode: String
        get() = preferences.getString(APP_MODE.first, APP_MODE.second) ?: ""
        set(value) = preferences.edit {
            it.putString(APP_MODE.first, value)
        }
    var job: String
        get() = preferences.getString(JOB.first, JOB.second) ?: ""
        set(value) = preferences.edit {
            it.putString(JOB.first, value)
        }
    var skills: String
        get() = preferences.getString(SKILLS.first, SKILLS.second) ?: ""
        set(value) = preferences.edit {
            it.putString(SKILLS.first, value)
        }
    var dates: String
        get() = preferences.getString(DATES.first, DATES.second) ?: ""
        set(value) = preferences.edit {
            it.putString(DATES.first, value)
        }
}