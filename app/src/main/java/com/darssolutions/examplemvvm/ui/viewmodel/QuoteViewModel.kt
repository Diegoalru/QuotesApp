package com.darssolutions.examplemvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.darssolutions.examplemvvm.data.model.QuoteModel
import com.darssolutions.examplemvvm.domain.GetQuotesUseCase
import com.darssolutions.examplemvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    //#region Variables
    private val _quote = MutableLiveData<QuoteModel?>()
    private val _isLoading = MutableLiveData<Boolean>()
    val hasData: LiveData<Boolean> = quote.map { it != null }

    val quote: MutableLiveData<QuoteModel?>
        get() = _quote
    val isLoading: MutableLiveData<Boolean>
        get() = _isLoading
    //#endregion

    fun onCreate() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val result = getQuotesUseCase()

                if (result.isNotEmpty()) {
                    _quote.value = result.random()
                }
            } catch (e: UnknownHostException) {
                Log.e(TAG, "No internet connectionQ")
            } catch (e: Exception) {
                Log.e(TAG, "Unknown error: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            _isLoading.value = true
            _quote.value = getRandomQuoteUseCase()
            _isLoading.value = false
        }
    }

    companion object
    {
        private const val TAG = "[QuoteViewModel]"
    }
}
