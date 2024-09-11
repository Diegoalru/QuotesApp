package com.darssolutions.examplemvvm.ui.screen.qoute

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darssolutions.examplemvvm.R
import com.darssolutions.examplemvvm.domain.model.QuoteItem
import com.darssolutions.examplemvvm.ui.theme.AppTheme
import com.darssolutions.examplemvvm.ui.viewmodel.QuoteState
import com.darssolutions.examplemvvm.ui.viewmodel.QuoteViewModel

@Composable
fun QuoteScreen(
    viewModel: QuoteViewModel,
    modifier: Modifier = Modifier
) {
    val quoteState by viewModel.quoteState.collectAsState()
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                enabled = quoteState !is QuoteState.Loading,
                onClick = viewModel::randomQuote,
                indication = null,
                interactionSource = interactionSource
            )
    ) {
        when (quoteState) {
            is QuoteState.Loading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
            is QuoteState.Success -> Quote((quoteState as QuoteState.Success).quote)
            is QuoteState.NoQuotes -> NoQuoteFound(
                stringResource(R.string.no_quotes_found),
                viewModel::randomQuote,
                Modifier.align(Alignment.Center)
            )

            is QuoteState.NoInternet -> NoQuoteFound(
                stringResource(R.string.no_internet_connection),
                viewModel::randomQuote,
                Modifier.align(Alignment.Center)
            )

            is QuoteState.Error -> NoQuoteFound(
                stringResource(R.string.an_error_occurred),
                viewModel::randomQuote,
                Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun NoQuoteFound(
    errorMessage: String,
    onRequestQuote: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = errorMessage,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = onRequestQuote,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary
            ),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = stringResource(R.string.refresh),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(
                modifier = Modifier.size(ButtonDefaults.IconSpacing)
            )
            Text(
                text = stringResource(R.string.refresh),
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun Quote(quote: QuoteItem) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        QuoteText(quote.quote, 24.sp)
        QuoteText(quote.author, 16.sp)
    }
}

@Composable
fun QuoteText(text: String, fontSize: TextUnit, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = fontSize,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun QuoteScreenPreview() {
    val quote = QuoteItem("This is a quote", "This is an author")

    AppTheme {
        Quote(quote)
    }
}

@Preview(showBackground = true, heightDp = 400, widthDp = 320)
@Preview(showBackground = true, heightDp = 400, widthDp = 320, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NoQuoteFoundPreview() {
    AppTheme {
        Box {
            NoQuoteFound(
                errorMessage = "No quotes available",
                onRequestQuote = {},
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
