package com.silverhetch.herse.model

import androidx.room.Room
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class DaoTest {
    @Test
    fun newEvent_checkEvent() {
        Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application,
            HerseDatabase::class.java
        ).allowMainThreadQueries().build().dao().run {
            newEvent(Event(0, "NewName", 100), Meta(
                0,
                0,
                System.currentTimeMillis(),
                0,
                0,
                0,
                0,
                0,
                0)
            )
            assertEquals("NewName", allEvent()[0].event.name)
            assertEquals(100, allEvent()[0].event.amount)
            assertEquals(1, allEvent().size)
        }
    }

    @Test
    fun newEvent_checkMeta() {
        Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application,
            HerseDatabase::class.java
        ).allowMainThreadQueries().build().dao().run {
            newEvent(Event(0, "NewName", 100), Meta(
                0,
                0,
                System.currentTimeMillis(),
                0,
                0,
                0,
                0,
                0,
                0)
            )
            assertEquals("NewName", allEvent()[0].event.name)
            assertEquals(100, allEvent()[0].event.amount)
            assertEquals(1, allEvent().size)
            assertEquals(0, allEvent()[0].meta[0].year)
        }
    }

    @Test
    fun queryById() {
        Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application,
            HerseDatabase::class.java
        ).allowMainThreadQueries().build().dao().run {
            newEvent(Event(0, "NewName", 100), Meta(
                0,
                0,
                System.currentTimeMillis(),
                0,
                0,
                0,
                0,
                0,
                0)
            )
            assertEquals("NewName", eventById(1).name)
            assertEquals(100, eventById(1).amount)
            assertEquals(0, allEvent()[0].meta[0].year)
        }
    }
}