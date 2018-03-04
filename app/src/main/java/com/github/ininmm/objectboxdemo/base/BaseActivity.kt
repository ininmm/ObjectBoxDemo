package com.github.ininmm.objectboxdemo.base

import android.support.v7.app.AppCompatActivity
import com.github.ininmm.objectboxdemo.util.logd

/**
 * Created by User
 * on 2018/3/4.
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()
        this::class.java.simpleName.logd("BaseActivity")
    }
}