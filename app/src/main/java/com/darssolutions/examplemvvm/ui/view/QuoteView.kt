package com.darssolutions.examplemvvm.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.darssolutions.examplemvvm.ui.screen.qoute.QuoteScreen
import com.darssolutions.examplemvvm.ui.theme.AppTheme
import com.darssolutions.examplemvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragmento que muestra citas en la interfaz de usuario.
 */
@AndroidEntryPoint
class QuoteView : Fragment() {

    private val viewModel: QuoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                viewModel.onCreate()
                QuoteScreen(viewModel = viewModel)
            }
        }
    }
}
