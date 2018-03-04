package com.github.ininmm.objectboxdemo

import android.app.Application
import io.objectbox.BoxStore

/**
 * Created by User
 * on 2018/3/4.
 */
class App : Application() {

    companion object {
        const val TAG = "APP"
    }

    lateinit var boxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        boxStore = MyObjectBox.builder().androidContext(this).build()
    }
}