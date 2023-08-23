package com.darssolutions.examplemvvm.data.network

import com.darssolutions.examplemvvm.core.RetrofitHelper
import com.darssolutions.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes() : List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).fetchQuotes()
            response.body() ?: emptyList()
        }

    }

}
