package com.raywenderlich.myapplication.koin_normal

class HelloRepositoryImpl() : HelloRepository {
    override fun giveHello() = "Hello Koin"
}