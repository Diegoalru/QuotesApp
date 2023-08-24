package com.darssolutions.examplemvvm.data.network.api

import com.darssolutions.examplemvvm.data.network.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Interfaz que define las operaciones para obtener citas desde la fuente de datos en la red.
 */
interface QuoteApiClient {

    /**
     * Obtiene citas desde la fuente de datos en la red.
     *
     * @return Respuesta de Retrofit con la lista de citas.
     */
    @GET("/.json")
    suspend fun fetchQuotes(): Response<List<QuoteModel>>
}
