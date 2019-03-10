package com.silverhetch.herse.model

import android.arch.persistence.room.Room
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class DaoTest {
    @Test
    fun simple() {
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
            assertEquals("NewName", allEvent()[0].name)
            assertEquals(100, allEvent()[0].amount)
            assertEquals(1, allEvent().size)
        }
    }
}