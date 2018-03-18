package com.github.ininmm.objectboxdemo.base

import android.support.v7.app.AppCompatActivity
import com.github.ininmm.objectboxdemo.util.logd
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by User
 * on 2018/3/4.
 */
abstract class BaseActivity : AppCompatActivity() {
    private val baseCompositeDisposable by lazy { CompositeDisposable() }

    fun addDisposable(disposable: Disposable) {
        baseCompositeDisposable.add(disposable)
    }

    fun addAllDisposable(vararg disposable: Disposable) {
        baseCompositeDisposable.addAll(*disposable)
    }

    fun deleteDisposable(disposable: Disposable) {
        baseCompositeDisposable.remove(disposable)
    }

    fun checkIsDisposable(): Boolean {
        return baseCompositeDisposable.isDisposed
    }

    override fun onResume() {
        super.onResume()
        this::class.java.simpleName.logd("BaseActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        baseCompositeDisposable.clear()
    }
}