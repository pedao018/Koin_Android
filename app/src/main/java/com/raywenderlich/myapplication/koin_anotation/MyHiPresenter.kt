package com.raywenderlich.myapplication.koin_anotation

import org.koin.core.annotation.Factory

@Factory
class MyHiPresenter(val repo: HiRepository) {
    fun sayHi() = "${repo.giveHi()} from $this"
}