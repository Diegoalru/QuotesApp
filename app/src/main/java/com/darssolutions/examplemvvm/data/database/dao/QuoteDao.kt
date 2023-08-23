package com.darssolutions.examplemvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.darssolutions.examplemvvm.data.database.entities.QuoteEntity

/**
 * Data Access Object (DAO) para la tabla de citas en la base de datos.
 */
@Dao
interface QuoteDao {

    /**
     * Obtiene todas las citas almacenadas en la base de datos.
     *
     * @return Lista de entidades de citas almacenadas.
     */
    @Query("SELECT id, quote, author FROM Quotes")
    suspend fun getAllQuotes(): List<QuoteEntity>

    /**
     * Inserta o reemplaza varias citas en la base de datos.
     *
     * @param quotes Lista de entidades de citas a insertar/reemplazar.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllQuotes(quotes: List<QuoteEntity>)

    /**
     * Elimina todas las citas almacenadas en la base de datos.
     */
    @Query("DELETE FROM Quotes")
    suspend fun deleteAllQuotes()
}
