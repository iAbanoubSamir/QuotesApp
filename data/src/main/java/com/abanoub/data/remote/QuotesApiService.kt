package com.abanoub.data.remote

import com.abanoub.domain.model.QuoteResponse
import retrofit2.http.GET

interface QuotesApiService {

    @GET("quotes")
    fun getQuotes(): QuoteResponse
}