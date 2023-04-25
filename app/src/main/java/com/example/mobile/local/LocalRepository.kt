package com.example.mobile.local

import android.content.Context

class LocalRepository(private val context: Context) : LocalDataSource {

    private val pref by lazy {
        context.getSharedPreferences("Application ID", Context.MODE_PRIVATE)
    }
}