package com.darssolutions.examplemvvm.domain

import com.darssolutions.examplemvvm.data.QuoteRepository
import com.darssolutions.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getQuotesFromDB()

        if (quotes.isNotEmpty()) {
            return quotes.random()
        }

        return null
    }
}
