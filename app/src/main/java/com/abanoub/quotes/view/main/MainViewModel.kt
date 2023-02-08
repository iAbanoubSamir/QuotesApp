package com.abanoub.quotes.view.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abanoub.domain.model.QuoteResponse
import com.abanoub.domain.usecase.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase
) : ViewModel() {

    private val _quotes: MutableStateFlow<QuoteResponse?> = MutableStateFlow(null)
    val quotes: StateFlow<QuoteResponse?> = _quotes

    fun getQuotes() {
        viewModelScope.launch {
            try {
                _quotes.value = getQuotesUseCase()
            } catch (e: Exception) {
                Log.d("MainViewModel", "getQuotesError: ${e.message}")
            }
        }
    }
}