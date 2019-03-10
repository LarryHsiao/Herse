package com.silverhetch.herse.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_meta")
data class Meta(
    @PrimaryKey var id: Long,
    @ColumnInfo(name = "event_id") var eventId: Long,
    @ColumnInfo var start: Long,
    @ColumnInfo var interval: Long,
    @ColumnInfo var year: Long,
    @ColumnInfo var month: Int,
    @ColumnInfo var day: Int,
    @ColumnInfo var week: Int,
    @ColumnInfo var weekday: Int
)