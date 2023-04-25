package com.example.mobile.arch.extension

import android.app.Activity
import android.widget.Toast

internal fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}