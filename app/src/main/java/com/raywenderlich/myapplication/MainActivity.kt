package com.raywenderlich.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raywenderlich.myapplication.databinding.ActivityMainBinding
import com.raywenderlich.myapplication.koin_anotation.HiViewModel
import com.raywenderlich.myapplication.koin_anotation.MyHiPresenter
import com.raywenderlich.myapplication.koin_normal.KoinConstants
import com.raywenderlich.myapplication.koin_normal.MySimplePresenter
import com.raywenderlich.myapplication.koin_normal.MyViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {

    //The by inject() function allows us to retrieve Koin instances, in Android components runtime (Activity, fragment, Service...)
    val singlePresenter: MySimplePresenter by inject(named(KoinConstants.MySimplePresenter_Single))
    val factoryPresenter: MySimplePresenter by inject(named(KoinConstants.MySimplePresenter_Factory))

    //The get() function is here to retrieve directly an instance (non lazy)
    val getPresenter: MySimplePresenter = get(named(KoinConstants.MySimplePresenter_Single))

    //The by viewModel() function allows us to retrieve a ViewModel instance from Koin, linked to the Android ViewModelFactory.
    val myViewModel: MyViewModel by viewModel()

    //The getViewModel() function is here to retrieve directly an instance (non lazy)
    //val getViewModel: MyViewModel = getViewModel()

    val myHiPresenter: MyHiPresenter by inject()
    val hiViewModel: HiViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnTest.setOnClickListener { printLog() }
        binding.btnTestAnotation.setOnClickListener { printLogAnotation() }
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


        Log.e("hahaha", "10${myViewModel.sayHello()}")
        Log.e("hahaha", "11${myViewModel.sayHello()}")
        Log.e("hahaha", "12${myViewModel.sayHello()}")
        /* Truoc khi xoay man hinh
2022-09-07 13:51:39.639 11248-11248/com.raywenderlich.myapplication E/hahaha: 1Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:51:39.639 11248-11248/com.raywenderlich.myapplication E/hahaha: 2Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:51:39.639 11248-11248/com.raywenderlich.myapplication E/hahaha: 3Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:51:39.639 11248-11248/com.raywenderlich.myapplication E/hahaha: 4Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@ed0074b
2022-09-07 13:51:39.639 11248-11248/com.raywenderlich.myapplication E/hahaha: 5Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@ed0074b
2022-09-07 13:51:39.639 11248-11248/com.raywenderlich.myapplication E/hahaha: 6Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@ed0074b
2022-09-07 13:51:39.639 11248-11248/com.raywenderlich.myapplication E/hahaha: 7Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:51:39.639 11248-11248/com.raywenderlich.myapplication E/hahaha: 8Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:51:39.639 11248-11248/com.raywenderlich.myapplication E/hahaha: 9Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:51:39.641 11248-11248/com.raywenderlich.myapplication E/hahaha: 10Hello Koin from com.raywenderlich.myapplication.koin_normal.MyViewModel@fce2528
2022-09-07 13:51:39.641 11248-11248/com.raywenderlich.myapplication E/hahaha: 11Hello Koin from com.raywenderlich.myapplication.koin_normal.MyViewModel@fce2528
2022-09-07 13:51:39.641 11248-11248/com.raywenderlich.myapplication E/hahaha: 12Hello Koin from com.raywenderlich.myapplication.koin_normal.MyViewModel@fce2528
        * */

        /*Sau khi xoay man hinh
2022-09-07 13:52:05.615 11248-11248/com.raywenderlich.myapplication E/hahaha: 1Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 2Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 3Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 4Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@ce04519
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 5Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@ce04519
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 6Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@ce04519
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 7Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 8Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 9Hello Koin from com.raywenderlich.myapplication.koin_normal.MySimplePresenter@a6f601a
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 10Hello Koin from com.raywenderlich.myapplication.koin_normal.MyViewModel@fce2528
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 11Hello Koin from com.raywenderlich.myapplication.koin_normal.MyViewModel@fce2528
2022-09-07 13:52:05.616 11248-11248/com.raywenderlich.myapplication E/hahaha: 12Hello Koin from com.raywenderlich.myapplication.koin_normal.MyViewModel@fce2528
        * */
    }

    private fun printLogAnotation() {
        Log.e("hahaha", "1${myHiPresenter.sayHi()}")
        Log.e("hahaha", "2${hiViewModel.sayHi()}")
    }
}