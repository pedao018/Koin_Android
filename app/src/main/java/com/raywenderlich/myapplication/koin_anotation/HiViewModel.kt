package com.raywenderlich.myapplication.koin_anotation

import androidx.lifecycle.ViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HiViewModel(val repo: HiRepository) : ViewModel() {
    fun sayHi() = "${repo.giveHi()} from $this"
}