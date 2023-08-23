package com.darssolutions.examplemvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.darssolutions.examplemvvm.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {
    @Query("SELECT id, quote, author FROM Quotes")
    suspend fun getAllQuotes(): List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllQuotes(quotes: List<QuoteEntity>)

    @Query("DELETE FROM Quotes")
    suspend fun deleteAllQuotes()
}
