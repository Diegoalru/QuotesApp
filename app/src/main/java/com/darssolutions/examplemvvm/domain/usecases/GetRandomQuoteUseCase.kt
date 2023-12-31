package com.darssolutions.examplemvvm.domain.usecases

import com.darssolutions.examplemvvm.data.repository.QuoteRepository
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import javax.inject.Inject

/**
 * Caso de uso que maneja la obtención de una cita aleatoria desde la base de datos local.
 *
 * @param repository Repositorio que proporciona acceso a las citas almacenadas en la base de datos.
 */
class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    /**
     * Obtén una cita aleatoria desde la base de datos local.
     *
     * @return Cita aleatoria obtenida desde la base de datos, o null si no hay citas disponibles.
     */
    suspend operator fun invoke(): QuoteItem? {
        val quotesFromDB = repository.getQuotesFromDB()

        if (quotesFromDB.isNotEmpty()) {
            return quotesFromDB.random()
        }

        return null
    }
}
