package com.example.freelance_app.view.screens

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "User"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    //SharedPreferences variables: (we have only one)
    private val APP_MODE = Pair("mode", "")

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

}