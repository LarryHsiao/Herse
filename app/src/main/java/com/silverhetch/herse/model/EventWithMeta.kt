package com.silverhetch.herse.model

import androidx.room.Embedded
import androidx.room.Relation

class EventWithMeta {
    @Embedded
    lateinit var event: Event

    @Relation(
        parentColumn = "id",
        entityColumn = "event_id"
    )
    lateinit var meta: List<Meta>
}