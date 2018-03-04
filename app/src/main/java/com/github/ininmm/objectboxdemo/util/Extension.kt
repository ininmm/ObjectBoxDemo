package com.github.ininmm.objectboxdemo.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.github.ininmm.objectboxdemo.BuildConfig

/**
 * Created by User
 * on 2018/3/4.
 */
fun String.logd(tag: String) {
    if (BuildConfig.DEBUG)
        Log.d(tag, this)
}

fun String.logi(tag: String) {
    if (BuildConfig.DEBUG)
        Log.i(tag, this)
}

fun String.loge(tag: String) {
    if (BuildConfig.DEBUG)
        Log.e(tag, this)
}

fun String.toast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}

fun getMemorySpace() {
    val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
    Log.d("TAG", "Max memory is " + maxMemory + "KB")
}
