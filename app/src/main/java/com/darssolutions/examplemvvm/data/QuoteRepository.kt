package com.darssolutions.examplemvvm.data

import com.darssolutions.examplemvvm.data.database.dao.QuoteDao
import com.darssolutions.examplemvvm.data.database.entities.QuoteEntity
import com.darssolutions.examplemvvm.data.network.QuoteService
import com.darssolutions.examplemvvm.domain.model.Quote
import com.darssolutions.examplemvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getQuotesFromAPI(): List<Quote> {
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getQuotesFromDB(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAllQuotes(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}
