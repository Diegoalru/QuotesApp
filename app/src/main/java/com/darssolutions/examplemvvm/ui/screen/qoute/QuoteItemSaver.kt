package com.darssolutions.examplemvvm.ui.screen.qoute

import androidx.compose.runtime.saveable.Saver
import com.darssolutions.examplemvvm.domain.model.QuoteItem

val QuoteItemSaver = Saver<QuoteItem?, Any>(
    save = { quoteItem ->
        if (quoteItem == null) {
            return@Saver null
        }

        listOf(quoteItem.quote, quoteItem.author)
    },
    restore = { restoredList ->
        val (quote, author) = restoredList as List<*>
        QuoteItem(quote as String, author as String)
    }
)
