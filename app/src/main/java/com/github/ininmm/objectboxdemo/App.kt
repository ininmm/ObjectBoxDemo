package com.github.ininmm.objectboxdemo

import android.app.Application
import com.github.ininmm.objectboxdemo.model.MyObjectBox
import io.objectbox.BoxStore

/**
 * Created by User
 * on 2018/3/4.
 */
class App : Application() {

    companion object {
        val TAG = this::class.java.simpleName
        @JvmStatic lateinit var instance: App
    }

    lateinit var boxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        instance = this
        boxStore = MyObjectBox.builder().androidContext(this).build()
    }
}