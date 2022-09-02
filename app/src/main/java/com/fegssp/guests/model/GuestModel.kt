package com.fegssp.guests.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Guest")
class GuestModel{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id: Int = 0

    @ColumnInfo
    var name: String = ""

    @ColumnInfo
    var presence: Boolean = false
}