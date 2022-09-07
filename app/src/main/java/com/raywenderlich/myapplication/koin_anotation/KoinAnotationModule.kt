package com.raywenderlich.myapplication.koin_anotation

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan("com.raywenderlich.myapplication")
class KoinAnotationModule