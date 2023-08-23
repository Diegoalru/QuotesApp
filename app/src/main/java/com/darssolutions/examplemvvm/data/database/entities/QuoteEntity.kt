package com.darssolutions.examplemvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.darssolutions.examplemvvm.domain.model.QuoteItem

/**
 * Entidad que representa una cita en la base de datos local.
 *
 * @param id Identificador único de la cita.
 * @param quote Texto de la cita.
 * @param author Autor de la cita.
 */
@Entity(tableName = "Quotes")
data class QuoteEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") val id: Int = 0,
    @ColumnInfo(name="quote") val quote: String,
    @ColumnInfo(name="author") val author: String
)

/**
 * Convierte un objeto Quote del dominio en una entidad QuoteEntity para la base de datos.
 *
 * @return Entidad QuoteEntity convertida.
 */
fun QuoteItem.toDatabase() = QuoteEntity(quote = quote, author = author)
