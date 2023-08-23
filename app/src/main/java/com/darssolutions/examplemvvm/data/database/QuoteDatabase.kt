package com.darssolutions.examplemvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.darssolutions.examplemvvm.data.database.dao.QuoteDao
import com.darssolutions.examplemvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1, exportSchema = true)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

}
