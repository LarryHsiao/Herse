package com.silverhetch.herse.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface HerseDao {
    @Query("select * from events;")
    fun allEvent(): List<Event>

    @Transaction
    fun newEvent(event: Event, vararg meta: Meta) {
        val eventId = newEvent(event)
        meta.forEach {
            it.eventId = eventId
            newMeta(it)
        }
    }

    @Insert
    fun newEvent(event: Event): Long

    @Insert(onConflict = REPLACE)
    fun newMeta(meta: Meta)
}