package com.abanoub.domain.repo

import com.abanoub.domain.model.QuoteResponse

interface QuotesRepository {
    fun getQuotesFromRemote(): QuoteResponse
}