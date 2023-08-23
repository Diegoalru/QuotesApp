package com.darssolutions.examplemvvm.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.darssolutions.examplemvvm.data.QuoteRepository
import com.darssolutions.examplemvvm.domain.GetQuotesUseCase
import com.darssolutions.examplemvvm.domain.GetRandomQuoteUseCase
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuoteViewModelTest {

    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase
    private lateinit var quoteViewModel: QuoteViewModel

    /**
     * Permite ejecutar las tareas en el hilo principal.
     */
    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuoteUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when onCreate is called and there is no internet connection`() = runTest {
        // When
        coEvery { quoteRepository.getQuotesFromAPI() } returns emptyList()

        // When
        quoteViewModel.onCreate()

        // Then
        coVerify(exactly = 1) { quoteRepository.getQuotesFromDB() }
    }

    @Test
    fun `when viewModel is created and set the quote`() = runTest {
        // Given
        val quoteList = listOf(QuoteItem("quote", "author"))
        coEvery { getQuotesUseCase() } returns quoteList

        // When
        quoteViewModel.onCreate()

        // Then
        assertEquals(quoteList.first(), quoteViewModel.quote.value)
    }

    @Test
    fun `when randomQuote is called and there is no internet connection`() = runTest {
        // Given
        coEvery { getRandomQuoteUseCase() } returns null

        // When
        quoteViewModel.randomQuote()

        // Then
        assertNull(quoteViewModel.quote.value)
        quoteViewModel.hasData.value?.let { assertFalse(it) }
        quoteViewModel.isLoading.value?.let { assertFalse(it) }
    }

    @Test
    fun `when randomQuote is called and change the quote`() = runTest {
        // Given
        val quote = QuoteItem("quote", "author")
        coEvery { getRandomQuoteUseCase() } returns quote

        // When
        quoteViewModel.randomQuote()

        // Then
        assertEquals(quote, quoteViewModel.quote.value)
        quoteViewModel.isLoading.value?.let { assertFalse(it) }
        quoteViewModel.hasData.value?.let { assertTrue(it) }
    }

    @Test
    fun `if randomQuoteUseCase return null keep the last value`() = runTest {
        // Given
        val quote = QuoteItem("quote", "author")
        coEvery { getRandomQuoteUseCase() } returns quote

        // When
        quoteViewModel.randomQuote()
        coEvery { getRandomQuoteUseCase() } returns null
        quoteViewModel.randomQuote()

        // Then
        assertEquals(quote, quoteViewModel.quote.value)
        quoteViewModel.isLoading.value?.let { assertFalse(it) }
        quoteViewModel.hasData.value?.let { assertTrue(it) }
    }
}
