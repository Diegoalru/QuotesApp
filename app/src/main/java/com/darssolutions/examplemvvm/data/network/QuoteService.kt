package com.darssolutions.examplemvvm.data.network

import com.darssolutions.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Servicio que maneja las operaciones para obtener citas desde la fuente de datos en la red.
 *
 * @param api Instancia de QuoteApiClient para realizar las solicitudes de red.
 */
class QuoteService @Inject constructor(private val api: QuoteApiClient) {

    /**
     * Obtiene citas desde la fuente de datos en la red.
     *
     * @return Lista de citas obtenidas.
     */
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = api.fetchQuotes()
            response.body() ?: emptyList()
        }
    }
}
