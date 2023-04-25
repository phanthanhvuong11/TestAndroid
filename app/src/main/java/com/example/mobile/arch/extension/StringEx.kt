package com.example.mobile.arch.extension

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan

internal fun String.setTextColorSpannableString(
    startIndex: Int, endIndex: Int, color: Int
): SpannableString {
    val textSpannable = SpannableString(this)

    textSpannable.setSpan(
        ForegroundColorSpan(color), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_INCLUSIVE
    )

    textSpannable.setSpan(
        Typeface.BOLD, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    return textSpannable
}