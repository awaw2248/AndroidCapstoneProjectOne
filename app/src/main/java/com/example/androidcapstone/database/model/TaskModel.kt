package com.example.androidcapstone.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TaskModel(
    val name: String,
    var completion: Boolean,
    val date: String,

@PrimaryKey (autoGenerate = true)
    val id: Int = 0

)
