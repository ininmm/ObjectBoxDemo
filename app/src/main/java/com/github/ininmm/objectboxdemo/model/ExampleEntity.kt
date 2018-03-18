package com.github.ininmm.objectboxdemo.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Created by User
 * on 2018/3/4.
 */
@Entity
data class ExampleEntity(@Id var id: Long = 0, var name: String? = null, var age: Int = -1, var address: String? = null,
                    var text: String? = null, var comment: String? = null)