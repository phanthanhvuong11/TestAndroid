package com.example.mobile.test.mobile

import com.example.mobile.model.Joke

interface MainVMContract {
    val jokes: List<Joke>
    val listIndex: MutableList<Int>
    fun setId(index: Int)

}