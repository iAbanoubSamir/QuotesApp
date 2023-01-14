package com.abanoub.domain.repository

import com.abanoub.domain.model.QuoteResponse

interface QuotesRepository {
    fun getQuotesFromAPI(): QuoteResponse
}