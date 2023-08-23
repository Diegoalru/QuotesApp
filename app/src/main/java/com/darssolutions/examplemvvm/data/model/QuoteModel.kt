package com.darssolutions.examplemvvm.data.model

import com.google.gson.annotations.SerializedName

/**
 * Modelo de datos que representa una cita obtenida de la fuente de datos.
 *
 * @param quote Texto de la cita.
 * @param author Autor de la cita.
 */
data class QuoteModel(
    @SerializedName("quote")
    val quote: String,
    @SerializedName("author")
    val author: String
)
