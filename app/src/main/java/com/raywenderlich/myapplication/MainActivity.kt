package com.raywenderlich.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raywenderlich.myapplication.databinding.ActivityMainBinding
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {

    //The by inject() function allows us to retrieve Koin instances, in Android components runtime (Activity, fragment, Service...)
    val singlePresenter: MySimplePresenter by inject(named(KoinConstants.MySimplePresenter_Single))
    val factoryPresenter: MySimplePresenter by inject(named(KoinConstants.MySimplePresenter_Factory))

    //The get() function is here to retrieve directly an instance (non lazy)
    val getPresenter: MySimplePresenter = get(named(KoinConstants.MySimplePresenter_Single))

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnTest.setOnClickListener { printLog() }
    }

    private fun printLog() {
        Log.e("hahaha", "1${singlePresenter.sayHello()}")
        Log.e("hahaha", "2${singlePresenter.sayHello()}")
        Log.e("hahaha", "3${singlePresenter.sayHello()}")

        Log.e("hahaha", "4${factoryPresenter.sayHello()}")
        Log.e("hahaha", "5${factoryPresenter.sayHello()}")
        Log.e("hahaha", "6${factoryPresenter.sayHello()}")

        Log.e("hahaha", "7${getPresenter.sayHello()}")
        Log.e("hahaha", "8${getPresenter.sayHello()}")
        Log.e("hahaha", "9${getPresenter.sayHello()}")
        /*
        2022-09-07 13:20:50.412 9804-9804/com.raywenderlich.myapplication E/hahaha: 1Hello Koin from com.raywenderlich.myapplication.MySimplePresenter@f794692
        2022-09-07 13:20:50.858 9804-9804/com.raywenderlich.myapplication E/hahaha: 2Hello Koin from com.raywenderlich.myapplication.MySimplePresenter@f794692
        2022-09-07 13:20:53.210 9804-9804/com.raywenderlich.myapplication E/hahaha: 3Hello Koin from com.raywenderlich.myapplication.MySimplePresenter@f794692
        2022-09-07 13:20:55.948 9804-9804/com.raywenderlich.myapplication E/hahaha: 4Hello Koin from com.raywenderlich.myapplication.MySimplePresenter@10fb863
        2022-09-07 13:21:06.892 9804-9804/com.raywenderlich.myapplication E/hahaha: 5Hello Koin from com.raywenderlich.myapplication.MySimplePresenter@10fb863
        2022-09-07 13:21:06.892 9804-9804/com.raywenderlich.myapplication E/hahaha: 6Hello Koin from com.raywenderlich.myapplication.MySimplePresenter@10fb863
        2022-09-07 13:21:06.892 9804-9804/com.raywenderlich.myapplication E/hahaha: 7Hello Koin from com.raywenderlich.myapplication.MySimplePresenter@f794692
        2022-09-07 13:21:06.893 9804-9804/com.raywenderlich.myapplication E/hahaha: 8Hello Koin from com.raywenderlich.myapplication.MySimplePresenter@f794692
        2022-09-07 13:21:06.893 9804-9804/com.raywenderlich.myapplication E/hahaha: 9Hello Koin from com.raywenderlich.myapplication.MySimplePresenter@f794692
        * */
    }
}