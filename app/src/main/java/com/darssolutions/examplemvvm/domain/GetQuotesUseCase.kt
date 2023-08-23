package com.darssolutions.examplemvvm.domain

import com.darssolutions.examplemvvm.data.QuoteRepository
import com.darssolutions.examplemvvm.data.database.entities.toDatabase
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import javax.inject.Inject

/**
 * Caso de uso que maneja la obtención de citas desde la fuente de datos,
 * ya sea la API o la base de datos local.
 *
 * @param repository Repositorio que proporciona acceso a las fuentes de datos.
 */
class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    /**
     * Obtén una lista de citas, primero desde la API y luego desde la base de datos,
     * en caso de que la API no tenga datos disponibles.
     *
     * @return Lista de citas obtenidas desde la fuente de datos.
     */
    suspend operator fun invoke(): List<QuoteItem> {
        val quotesFromAPI = repository.getQuotesFromAPI()

        return if (quotesFromAPI.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotesFromAPI.map { it.toDatabase() })
            quotesFromAPI
        } else {
            repository.getQuotesFromDB()
        }
    }
}
