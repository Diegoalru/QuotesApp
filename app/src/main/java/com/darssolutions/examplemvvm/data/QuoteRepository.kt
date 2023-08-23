package com.darssolutions.examplemvvm.data

import com.darssolutions.examplemvvm.data.database.dao.QuoteDao
import com.darssolutions.examplemvvm.data.database.entities.QuoteEntity
import com.darssolutions.examplemvvm.data.network.QuoteService
import com.darssolutions.examplemvvm.domain.model.Quote
import com.darssolutions.examplemvvm.domain.model.toDomain
import javax.inject.Inject

/**
 * Repositorio que maneja las operaciones de obtención y almacenamiento de citas.
 *
 * @param api Instancia del servicio de citas desde la red.
 * @param quoteDao Instancia del Data Access Object (DAO) de citas en la base de datos.
 */
class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    /**
     * Obtiene citas desde la fuente de datos en la red.
     *
     * @return Lista de citas obtenidas.
     */
    suspend fun getQuotesFromAPI(): List<Quote> {
        val response = api.getQuotes()
        return response.map { it.toDomain() }
    }

    /**
     * Obtiene citas almacenadas en la base de datos local.
     *
     * @return Lista de citas almacenadas en la base de datos.
     */
    suspend fun getQuotesFromDB(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    /**
     * Inserta citas en la base de datos local.
     *
     * @param quotes Lista de entidades de citas a insertar.
     */
    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAllQuotes(quotes)
    }

    /**
     * Elimina todas las citas almacenadas en la base de datos local.
     */
    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}
