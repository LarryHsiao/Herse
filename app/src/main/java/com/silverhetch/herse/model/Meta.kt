package com.silverhetch.herse.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

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