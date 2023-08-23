package com.darssolutions.examplemvvm.domain.model

import com.darssolutions.examplemvvm.data.database.entities.QuoteEntity
import com.darssolutions.examplemvvm.data.model.QuoteModel

/**
 * Clase de modelo que representa una cita en el dominio de la aplicación.
 *
 * @param quote Texto de la cita.
 * @param author Autor de la cita.
 */
data class Quote(val quote: String, val author: String)

/**
 * Convierte un objeto QuoteModel del módulo de datos a un objeto Quote en el dominio.
 *
 * @return Objeto Quote convertido.
 */
fun QuoteModel.toDomain() = Quote(quote, author)

/**
 * Convierte un objeto QuoteEntity del módulo de datos a un objeto Quote en el dominio.
 *
 * @return Objeto Quote convertido.
 */
fun QuoteEntity.toDomain() = Quote(quote, author)
