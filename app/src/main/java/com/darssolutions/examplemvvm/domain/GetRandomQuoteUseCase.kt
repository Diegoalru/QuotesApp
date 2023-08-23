package com.darssolutions.examplemvvm.domain

import com.darssolutions.examplemvvm.data.model.QuoteModel
import com.darssolutions.examplemvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {
    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes

        if (quotes.isNotEmpty()) {
            return quotes.random()
        }

        return null
    }
}
