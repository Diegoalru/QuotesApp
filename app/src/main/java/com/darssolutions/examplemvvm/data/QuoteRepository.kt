package com.darssolutions.examplemvvm.data

import com.darssolutions.examplemvvm.data.model.QuoteModel
import com.darssolutions.examplemvvm.data.model.QuoteProvider
import com.darssolutions.examplemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getQuotes() : List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}
