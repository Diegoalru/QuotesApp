package com.darssolutions.examplemvvm.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.darssolutions.examplemvvm.ui.screen.qoute.QuoteScreen
import com.darssolutions.examplemvvm.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteApp(modifier: Modifier = Modifier) {
    AppTheme {
        Scaffold { innerPadding ->
            QuoteScreen(modifier = modifier.padding(innerPadding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BankAppPreview() {
    QuoteApp()
}
