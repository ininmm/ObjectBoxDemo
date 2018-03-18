package com.github.ininmm.objectboxdemo.entity

import com.github.ininmm.objectboxdemo.App
import com.github.ininmm.objectboxdemo.model.ExampleEntity
import com.github.ininmm.objectboxdemo.model.ExampleEntity_
import io.objectbox.Box
import io.objectbox.query.Query
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by User
 * on 2018/3/17.
 */
class EntityModel {
    private val entityBox: Box<ExampleEntity> by lazy { App.instance.boxStore.boxFor(ExampleEntity::class.java) }

    fun getAllEntity() : Observable<MutableList<ExampleEntity>> {
        return Observable.create<MutableList<ExampleEntity>> {
            it.onNext(entityBox.query().build().find())
        }.subscribeOn(Schedulers.newThread())
    }

    fun getUserEntity(userName: String) : Observable<MutableList<ExampleEntity>> {
        return Observable.create<MutableList<ExampleEntity>> {
            val entityData = entityBox.query().equal(ExampleEntity_.name, userName)
                    .build()
                    .find()
            it.onNext(entityData)
        }.subscribeOn(Schedulers.newThread())
    }

    fun getUserEntity(Id: Long) : Observable<ExampleEntity> {
        return Observable.create<ExampleEntity> { action ->
            val entityData = entityBox.query().equal(ExampleEntity_.id, Id)
                    .build()
                    .findFirst()
            entityData?.let { data -> action.onNext(data) }
        }
    }

    fun save(vararg exampleEntities: ExampleEntity) {
        entityBox.put(*exampleEntities)
    }

    fun delete(vararg entityIds: Long) {
        entityBox.remove(*entityIds)
    }
}