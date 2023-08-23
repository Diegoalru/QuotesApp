package com.darssolutions.examplemvvm.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.darssolutions.examplemvvm.databinding.FragmentQuoteBinding
import com.darssolutions.examplemvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteView : Fragment() {

    private var _binding: FragmentQuoteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: QuoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onCreate()

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.hasData.observe(viewLifecycleOwner) {
            binding.txQuote.visibility = if (it) View.VISIBLE else View.GONE
            binding.txAuthor.visibility = if (it) View.VISIBLE else View.GONE
            binding.noDataMessage.visibility = if (!it) View.VISIBLE else View.GONE

            binding.txQuote.text = viewModel.quote.value?.quote ?: ""
            binding.txAuthor.text = viewModel.quote.value?.author ?: ""
        }

        binding.viewContainer.setOnClickListener { viewModel.randomQuote() }
    }
}
