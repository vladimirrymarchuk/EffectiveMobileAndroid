package com.example.data.service

import android.app.AppComponentFactory
import android.content.Context

private const val  SHARED_PREF_NAME = "shared_pref_name"
private const val PLACE_A = "placeA"
class SharedPrefService(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    fun getPlaceA(): String? = sharedPreferences.getString(PLACE_A, null)

    fun savePlaceA(text: String) {
        sharedPreferences.edit().putString(PLACE_A, text).apply()
    }
}