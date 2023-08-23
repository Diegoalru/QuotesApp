package com.darssolutions.examplemvvm.data.network

import com.darssolutions.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun fetchQuotes(): Response<List<QuoteModel>>
}
