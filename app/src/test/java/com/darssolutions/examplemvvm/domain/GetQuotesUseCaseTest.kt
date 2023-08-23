package com.darssolutions.examplemvvm.domain

import com.darssolutions.examplemvvm.data.QuoteRepository
import com.darssolutions.examplemvvm.data.database.entities.toDatabase
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetQuotesUseCaseTest {

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    @Test
    fun `when invoke getQuotesUseCase and nothing is returned from the API`() = runBlocking {
        // Given
        coEvery { quoteRepository.getQuotesFromAPI() } returns emptyList()

        // When
        getQuotesUseCase()

        // Then
        coVerify(exactly = 1) { quoteRepository.getQuotesFromDB() }
    }

    @Test
    fun `when invoke getQuotesUseCase and something is returned from the API`() = runBlocking {
        // Given
        val fakeQuotes = listOf(
            QuoteItem(
                quote = "Test quote",
                author = "Test author"
            )
        )
        coEvery { quoteRepository.getQuotesFromAPI() } returns fakeQuotes

        // When
        getQuotesUseCase()

        // Then
        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuotes(fakeQuotes.map { it.toDatabase() }) }
        coVerify(exactly = 0) { quoteRepository.getQuotesFromDB() }
    }
}
