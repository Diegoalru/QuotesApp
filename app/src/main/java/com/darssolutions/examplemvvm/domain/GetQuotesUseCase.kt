package com.darssolutions.examplemvvm.domain

import com.darssolutions.examplemvvm.data.QuoteRepository
import com.darssolutions.examplemvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel> {
        return repository.getQuotes()
    }

}
