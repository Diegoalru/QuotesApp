package com.darssolutions.examplemvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.darssolutions.examplemvvm.data.database.dao.QuoteDao
import com.darssolutions.examplemvvm.data.database.entities.QuoteEntity

/**
 * Base de datos local que contiene la tabla de citas.
 */
@Database(entities = [QuoteEntity::class], version = 1, exportSchema = true)
abstract class QuoteDatabase : RoomDatabase() {

    /**
     * Proporciona acceso al Data Access Object (DAO) de la tabla de citas.
     *
     * @return Instancia de QuoteDao.
     */
    abstract fun quoteDao(): QuoteDao

}
