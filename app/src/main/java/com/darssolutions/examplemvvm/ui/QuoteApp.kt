package com.darssolutions.examplemvvm.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.darssolutions.examplemvvm.ui.screen.qoute.QuoteScreen
import com.darssolutions.examplemvvm.ui.theme.AppTheme
import com.darssolutions.examplemvvm.ui.screen.qoute.QuoteViewModel

@Composable
fun QuoteApp(modifier: Modifier = Modifier) {
    val viewModel: QuoteViewModel = viewModel()

    AppTheme {
        Scaffold { innerPadding ->
            // Cargar las citas desde la API al inicio
            viewModel.loadInitialQuote()

            QuoteScreen(
                viewModel = viewModel,
                modifier = modifier.padding(innerPadding),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BankAppPreview() {
    QuoteApp()
}
