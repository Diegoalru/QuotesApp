package com.darssolutions.examplemvvm.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.darssolutions.examplemvvm.data.repository.QuoteRepository
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import com.darssolutions.examplemvvm.domain.usecases.GetQuotesUseCase
import com.darssolutions.examplemvvm.domain.usecases.GetRandomQuoteUseCase
import com.darssolutions.examplemvvm.ui.screen.qoute.QuoteState
import com.darssolutions.examplemvvm.ui.screen.qoute.QuoteViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.net.UnknownHostException

@ExperimentalCoroutinesApi
class QuoteViewModelTest {

    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    @RelaxedMockK
    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuoteUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    /**
     * Initial quote tests
     */

    @Test
    fun `when initial quote is called and quotes are available`() = runTest {
        val quote = QuoteItem("quote", "author")
        coEvery { quoteRepository.getQuotesFromAPI() } returns listOf(quote)

        quoteViewModel.loadInitialQuote()
        advanceUntilIdle()

        assertTrue(quoteViewModel.quoteState.value is QuoteState.Success)
        assertEquals(quote, (quoteViewModel.quoteState.value as QuoteState.Success).quote)
    }

    @Test
    fun `when initial quote is called and there is no quotes available`() = runTest {
        coEvery { quoteRepository.getQuotesFromAPI() } returns emptyList()
        coEvery { quoteRepository.getQuotesFromDB() } returns emptyList()

        quoteViewModel.loadInitialQuote()
        advanceUntilIdle()

        coVerify(exactly = 1) { quoteRepository.getQuotesFromDB() }
        assertTrue(quoteViewModel.quoteState.value is QuoteState.NoQuotes)
    }

    @Test
    fun `when loadInitialQuote is called and there is no internet connection`() = runTest {
        coEvery { getQuotesUseCase() } throws UnknownHostException()

        quoteViewModel.loadInitialQuote()
        advanceUntilIdle()

        assertTrue(quoteViewModel.quoteState.value is QuoteState.NoInternet)
    }

    @Test
    fun `when loadInitialQuote is called and an unknown error occurs`() = runTest {
        coEvery { getQuotesUseCase() } throws Exception()

        quoteViewModel.loadInitialQuote()
        advanceUntilIdle()

        assertTrue(quoteViewModel.quoteState.value is QuoteState.Error)
    }

    /**
     * Random quotes tests
     */
    @Test
    fun `when randomQuote is called and quotes are available`() = runTest {
        val quote = QuoteItem("quote", "author")
        coEvery { quoteRepository.getQuotesFromDB() } returns listOf(quote)

        quoteViewModel.randomQuote()
        advanceUntilIdle()

        assertTrue(quoteViewModel.quoteState.value is QuoteState.Success)
        assertEquals(quote, (quoteViewModel.quoteState.value as QuoteState.Success).quote)
    }

    @Test
    fun `when randomQuote is called and there is no quotes available`() = runTest {
        coEvery { quoteRepository.getQuotesFromDB() } returns emptyList()

        quoteViewModel.randomQuote()
        advanceUntilIdle()

        assertTrue(quoteViewModel.quoteState.value is QuoteState.NoQuotes)
    }
}
