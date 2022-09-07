package com.raywenderlich.myapplication.koin_normal

import android.util.Log
import androidx.lifecycle.ViewModel

class MyViewModel(val repo: HelloRepository) : ViewModel() {

    fun sayHello() = "${repo.giveHello()} from $this"

    override fun onCleared() {
        super.onCleared()
        Log.e("hahaha", "On Cleared")
    }
}