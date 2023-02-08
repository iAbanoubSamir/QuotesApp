package com.abanoub.domain.repository

import com.abanoub.domain.model.QuoteResponse

interface QuotesRepository {
    suspend fun getQuotesFromAPI(): QuoteResponse
}