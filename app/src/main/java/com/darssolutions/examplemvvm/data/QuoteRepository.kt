package com.darssolutions.examplemvvm.data

import com.darssolutions.examplemvvm.data.model.QuoteModel
import com.darssolutions.examplemvvm.data.model.QuoteProvider
import com.darssolutions.examplemvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {

    suspend fun getQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}
