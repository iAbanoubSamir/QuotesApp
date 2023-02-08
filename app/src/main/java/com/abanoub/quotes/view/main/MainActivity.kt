package com.abanoub.quotes.view.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.abanoub.quotes.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val quotesAdapter = QuotesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initQuotesRecycleView()

        observeForQuotesResponse()
    }

    private fun initQuotesRecycleView() {
        binding.quotesRecyclerView.apply {
            adapter = quotesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }

    private fun observeForQuotesResponse() {
        viewModel.getQuotes()
        lifecycleScope.launch {
            viewModel.quotes.collect { response ->
                quotesAdapter.submitList(response?.results)
            }
        }

    }
}