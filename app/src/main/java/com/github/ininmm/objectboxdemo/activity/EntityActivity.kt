package com.github.ininmm.objectboxdemo.activity

import android.os.Bundle
import com.github.ininmm.objectboxdemo.App
import com.github.ininmm.objectboxdemo.R
import com.github.ininmm.objectboxdemo.adapter.EntityAdapter
import com.github.ininmm.objectboxdemo.base.BaseActivity
import com.github.ininmm.objectboxdemo.model.ExampleEntity
import com.github.ininmm.objectboxdemo.model.ExampleEntity_
import io.objectbox.Box
import io.objectbox.android.AndroidScheduler
import io.objectbox.query.Query
import io.objectbox.reactive.DataSubscription
import io.objectbox.reactive.Scheduler
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EntityActivity : BaseActivity() {

    private lateinit var entityBox: Box<ExampleEntity>
    private lateinit var entityQuery: Query<ExampleEntity>
    private lateinit var entityAdapter: EntityAdapter
    private lateinit var subscription: DataSubscription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViews()

        entityBox = App.instance.boxStore.boxFor(ExampleEntity::class.java)
        entityQuery = entityBox.query().order(ExampleEntity_.text).build()
        subscription = entityQuery.subscribe().on(AndroidScheduler.mainThread()).observer { entityAdapter.setNotes(it) }
        addDisposable(Observable.create<Query<ExampleEntity>> {
            val query = entityBox.query()
                    .equal(ExampleEntity_.name, "Michael")
                    .greater(ExampleEntity_.age, 20)
                    .startsWith(ExampleEntity_.text, "asd")
            it.onNext(query.build())
//            it.onNext(entityQuery)
        }.subscribeOn(Schedulers.io())
                .map { return@map it.findLazy() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { entityAdapter.setNotes(it) })
    }

    fun setUpViews() {

    }
}
