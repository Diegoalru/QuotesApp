package com.darssolutions.examplemvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.darssolutions.examplemvvm.databinding.FragmentQuoteBinding
import com.darssolutions.examplemvvm.viewmodel.QuoteViewModel

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
        binding.viewContainer.setOnClickListener { viewModel.randomQuote() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel.quoteModel.observe(viewLifecycleOwner) { currentQuote ->
                binding.txQuote.text = currentQuote.quote
                binding.txAuthor.text = currentQuote.author
            }
        }
    }
}
