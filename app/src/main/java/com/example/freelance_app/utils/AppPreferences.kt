package com.example.freelance_app.view.screens

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "User"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    //SharedPreferences variables: (we have only one)
    private val DATA = Pair("data", "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var data: String
        get() = preferences.getString(DATA.first, DATA.second) ?: ""
        set(value) = preferences.edit {
            it.putString(DATA.first, value)
        }

}