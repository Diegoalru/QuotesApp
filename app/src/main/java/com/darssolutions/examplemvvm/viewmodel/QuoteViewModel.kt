package com.darssolutions.examplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.darssolutions.examplemvvm.model.QuoteModel
import com.darssolutions.examplemvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    private val _quoteModel = MutableLiveData<QuoteModel>()
    val quoteModel: MutableLiveData<QuoteModel>
        get() = _quoteModel

    init {
        randomQuote()
    }

    fun randomQuote() {
        _quoteModel.value = QuoteProvider.random()
    }
}
