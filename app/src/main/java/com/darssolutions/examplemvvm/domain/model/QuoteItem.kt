package com.darssolutions.examplemvvm.domain.model

import com.darssolutions.examplemvvm.data.database.entities.QuoteEntity
import com.darssolutions.examplemvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
