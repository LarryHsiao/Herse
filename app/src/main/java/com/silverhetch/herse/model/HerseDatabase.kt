package com.silverhetch.herse.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Event::class, Meta::class], version = 1)
abstract class HerseDatabase : RoomDatabase() {
    abstract fun dao(): HerseDao
}