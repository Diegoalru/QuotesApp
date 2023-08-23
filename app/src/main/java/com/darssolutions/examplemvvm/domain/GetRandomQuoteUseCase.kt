package com.darssolutions.examplemvvm.domain

import com.darssolutions.examplemvvm.data.model.QuoteModel
import com.darssolutions.examplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes

        if (quotes.isNotEmpty()) {
            return quotes.random()
        }

        return null
    }
}
