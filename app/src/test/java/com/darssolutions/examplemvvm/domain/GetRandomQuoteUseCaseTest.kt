package com.darssolutions.examplemvvm.domain

import com.darssolutions.examplemvvm.data.repository.QuoteRepository
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import com.darssolutions.examplemvvm.domain.usecases.GetRandomQuoteUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull

import org.junit.Before
import org.junit.Test

class GetRandomQuoteUseCaseTest {

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun setUp() {
        // Inicialización de MockK para anotaciones y creación de la instancia de la clase bajo prueba
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when invoke getRandomQuoteUseCase and nothing is returned from the DB`() = runBlocking {
        // Given
        coEvery { quoteRepository.getQuotesFromDB() } returns emptyList()

        // When
        val result = getRandomQuoteUseCase()

        // Then
        assertNull(result)
    }

    @Test
    fun `when invoke getRandomQuoteUseCase and something is returned from the DB`() = runBlocking {
        // Given
        val quote = QuoteItem("quote", "author")
        coEvery { quoteRepository.getQuotesFromDB() } returns listOf(quote)

        // When
        val result = getRandomQuoteUseCase()

        // Then
        assertEquals(quote, result)
    }
}
