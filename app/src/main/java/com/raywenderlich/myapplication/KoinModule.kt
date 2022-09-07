package com.raywenderlich.myapplication

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }

    // Simple Presenter Factory
    //We declare our MySimplePresenter class as factory to have a new instance created each time our Activity need one.
    single(qualifier = named(KoinConstants.MySimplePresenter_Single)) { MySimplePresenter(get()) }

    //We declare our MySimplePresenter class as factory to have a new instance created each time our Activity need one.
    factory(qualifier = named(KoinConstants.MySimplePresenter_Factory)) { MySimplePresenter(get()) }

    //we declare our MyViewModel class as a viewModel in a module. Koin will give a MyViewModel to the lifecycle ViewModelFactory and help bind it to the current component.
    viewModel { MyViewModel(get()) }
}

object KoinConstants {
    const val MySimplePresenter_Single = "MySimplePresenter_Single"
    const val MySimplePresenter_Factory = "MySimplePresenter_Factory"
}