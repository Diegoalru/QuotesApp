package com.darssolutions.examplemvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import com.darssolutions.examplemvvm.domain.usecases.GetQuotesUseCase
import com.darssolutions.examplemvvm.domain.usecases.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * ViewModel encargado de gestionar la lógica de presentación y manipulación
 * de datos relacionados con las citas.
 *
 * @param getQuotesUseCase Caso de uso para obtener citas desde una fuente de datos.
 * @param getRandomQuoteUseCase Caso de uso para obtener una cita aleatoria.
 */
@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    private val _quoteState = MutableStateFlow<QuoteState>(QuoteState.Loading)
    val quoteState: StateFlow<QuoteState> = _quoteState.asStateFlow()

    init {
        loadInitialQuote()
    }

    private fun loadInitialQuote() {
        viewModelScope.launch {
            _quoteState.value = QuoteState.Loading
            try {
                val result = getQuotesUseCase()
                if (result.isNotEmpty()) {
                    _quoteState.value = QuoteState.Success(result.random())
                } else {
                    _quoteState.value = QuoteState.NoQuotes
                }
            } catch (e: UnknownHostException) {
                Log.e(TAG, "No internet connection!", e)
                _quoteState.value = QuoteState.NoInternet
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching quotes", e)
                _quoteState.value = QuoteState.Error
            }
        }
    }

    fun randomQuote() {
        loadInitialQuote()
    }

    companion object {
        private const val TAG = "[QuoteViewModel]"
    }
}

sealed class QuoteState {
    data object Loading : QuoteState()
    data class Success(val quote: QuoteItem) : QuoteState()
    data object NoQuotes : QuoteState()
    data object NoInternet : QuoteState()
    data object Error : QuoteState()
}
