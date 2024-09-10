package com.darssolutions.examplemvvm.ui.screen.qoute

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.darssolutions.examplemvvm.R
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import com.darssolutions.examplemvvm.ui.theme.AppTheme
import com.darssolutions.examplemvvm.ui.viewmodel.QuoteViewModel

@Composable
fun QuoteScreen(viewModel: QuoteViewModel = viewModel()) {
    val isLoading by viewModel.isLoading.observeAsState(false)
    val hasData by viewModel.hasData.observeAsState(false)
    var quote by rememberSaveable(stateSaver = QuoteItemSaver) { mutableStateOf(null) }

    val viewModelQuote by viewModel.quote.observeAsState()
    if (viewModelQuote != null) quote = viewModelQuote

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                enabled = !isLoading,
                onClick = { viewModel.randomQuote() },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        when {
            isLoading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
            hasData -> quote?.let { QuoteCard(it) }
            else -> NoQuoteFound(
                getQuoteClick = { viewModel.randomQuote() },
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun NoQuoteFound(getQuoteClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = stringResource(R.string.no_data_found),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = stringResource(R.string.no_data_found),
                fontSize = 24.sp,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun QuoteCard(quote: QuoteItem) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        TextQuote(quote = quote.quote)
        TextAuthor(author = quote.author, modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun TextQuote(quote: String, modifier: Modifier = Modifier) {
    Text(
        text = quote,
        style = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}

@Composable
fun TextAuthor(author: String, modifier: Modifier = Modifier) {
    Text(
        text = author,
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun QuoteScreenPreview() {
    val quote = QuoteItem("This is a quote", "This is an author")
    AppTheme {
        QuoteCard(quote)
    }
}

@Preview(showBackground = true, heightDp = 400, widthDp = 320)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NoQuoteFoundPreview() {
    AppTheme {
        Box {
            NoQuoteFound({}, Modifier.align(Alignment.Center))
        }
    }
}
