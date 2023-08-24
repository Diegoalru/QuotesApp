package com.darssolutions.examplemvvm.domain.model

import com.darssolutions.examplemvvm.data.database.entities.QuoteEntity
import com.darssolutions.examplemvvm.data.network.model.QuoteModel

/**
 * Clase de modelo que representa una cita en el dominio de la aplicación.
 *
 * @param quote Texto de la cita.
 * @param author Autor de la cita.
 */
data class QuoteItem(val quote: String, val author: String)

/**
 * Convierte un objeto QuoteModel del módulo de datos a un objeto QuoteItem en el dominio.
 *
 * @return Objeto QuoteItem convertido.
 */
fun QuoteModel.toDomain() = QuoteItem(quote, author)

/**
 * Convierte un objeto QuoteEntity del módulo de datos a un objeto QuoteItem en el dominio.
 *
 * @return Objeto QuoteItem convertido.
 */
fun QuoteEntity.toDomain() = QuoteItem(quote, author)
