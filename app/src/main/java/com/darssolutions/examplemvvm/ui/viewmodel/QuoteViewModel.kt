package com.darssolutions.examplemvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import com.darssolutions.examplemvvm.domain.usecases.GetQuotesUseCase
import com.darssolutions.examplemvvm.domain.usecases.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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

    /**
     * Almacena la cita actual que será mostrada en pantalla.
     */
    private val _quote = MutableLiveData<QuoteItem?>()

    /**
     * Muestra el estado de carga de la cita.
     */
    private val _isLoading = MutableLiveData<Boolean>()

    /**
     * Muestra si hay datos en la cita.
     */
    val hasData: LiveData<Boolean> = _quote.map { it != null }

    val quote: MutableLiveData<QuoteItem?>
        get() = _quote
    val isLoading: MutableLiveData<Boolean>
        get() = _isLoading

    /**
     * Inicializa la obtención de citas al crearse la instancia del ViewModel.
     */
    fun onCreate() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val result = getQuotesUseCase()

                if (result.isNotEmpty()) {
                    _quote.value = result.random()
                }
            } catch (e: UnknownHostException) {
                Log.e(TAG, "No internet connection!")
            } finally {
                _isLoading.value = false
            }
        }
    }

    /**
     * Obtiene y establece una cita aleatoria, gestionando el estado de carga.
     */
    fun randomQuote() {
        viewModelScope.launch {
            _isLoading.value = true
            _quote.value =
                getRandomQuoteUseCase() ?: _quote.value // Si no hay cita, se mantiene la actual.
            _isLoading.value = false
        }
    }

    companion object {
        private const val TAG = "[QuoteViewModel]"
    }
}
