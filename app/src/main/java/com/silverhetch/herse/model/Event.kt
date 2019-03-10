package com.silverhetch.herse.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
    @PrimaryKey var id: Long,
    @ColumnInfo var name: String,
    @ColumnInfo var amount: Long
)