package com.darssolutions.examplemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.darssolutions.examplemvvm.ui.QuoteApp
import dagger.hilt.android.AndroidEntryPoint

/**
 * Actividad principal que aloja el fragmento de navegación.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteApp()
        }
    }
}
