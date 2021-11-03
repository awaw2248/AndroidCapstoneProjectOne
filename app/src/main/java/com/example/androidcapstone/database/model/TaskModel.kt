package com.example.androidcapstone.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

//defining my database to be an entity,
// which is The table name in the SQLite database

@Entity
data class TaskModel(
    var name: String,
    var completion: Boolean,
    var date: String,
    var description: String,
    var crationdate: String= Date().toString(),


    //"setting" true to let SQLite generate the unique "id"
@PrimaryKey (autoGenerate = true)
    val id: Int = 0

)
