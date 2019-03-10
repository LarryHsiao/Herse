package com.silverhetch.herse.model

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

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