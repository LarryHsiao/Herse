package com.silverhetch.herse.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Event::class, Meta::class], version = 1)
abstract class HerseDatabase : RoomDatabase() {
    abstract fun dao(): HerseDao
}