package com.github.ininmm.objectboxdemo.viewmodel.entity

import com.github.ininmm.objectboxdemo.entity.EntityModel
import com.github.ininmm.objectboxdemo.model.ExampleEntity
import io.reactivex.Observable

/**
 * Created by User
 * on 2018/3/17.
 */
class EntityViewModel {

    private val entityModel = EntityModel()

    fun getUser(): Observable<MutableList<ExampleEntity>> {
        return entityModel.getAllEntity()
    }
}