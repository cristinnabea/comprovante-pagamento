package com.example.comprovante.utils

import android.content.Context
import android.content.SharedPreferences
import android.widget.ImageView

class Prefs(context: Context) {
    val PREFS_FILENAME = "com.teamtreehouse.colorsarefun.prefs"
    val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, value: String, KEY_NAME2: String, value2: String, KEY_NAME3: String, value3: String, KEY_NAME4: String, value4: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putString(KEY_NAME, value)
        editor.putString(KEY_NAME2, value2)
        editor.putString(KEY_NAME3, value3)
        editor.putString(KEY_NAME4, value4)

        editor.commit()
    }


    fun getValueString(KEY_NAME: String): String? {

        return sharedPref.getString(KEY_NAME, null)
    }


}