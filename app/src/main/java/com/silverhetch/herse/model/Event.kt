package com.silverhetch.herse.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
    @PrimaryKey var id: Long,
    @ColumnInfo var name: String,
    @ColumnInfo var amount: Long
)