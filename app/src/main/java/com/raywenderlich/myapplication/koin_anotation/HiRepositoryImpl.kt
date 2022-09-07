package com.raywenderlich.myapplication.koin_anotation

import org.koin.core.annotation.Single

@Single
class HiRepositoryImpl() : HiRepository {
    override fun giveHi() = "Hi Koin"
}