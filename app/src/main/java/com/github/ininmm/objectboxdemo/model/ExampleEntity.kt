package com.github.ininmm.objectboxdemo.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Created by User
 * on 2018/3/4.
 */
@Entity
class ExampleEntity(@Id var id: Long, var name: String, var age: Int, var address: String?,
                    var text: String?, var comment: String?) {
}