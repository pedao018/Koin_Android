package com.raywenderlich.myapplication.koin_normal

class MySimplePresenter(val repo: HelloRepository) {

    fun sayHello() = "${repo.giveHello()} from $this"
}