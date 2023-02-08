package com.abanoub.data.repository

import com.abanoub.data.remote.QuotesApiService
import com.abanoub.domain.model.QuoteResponse
import com.abanoub.domain.repository.QuotesRepository

class QuotesRepositoryImpl(private val apiService: QuotesApiService) : QuotesRepository {

    override suspend fun getQuotesFromAPI(): QuoteResponse = apiService.getQuotes()

}