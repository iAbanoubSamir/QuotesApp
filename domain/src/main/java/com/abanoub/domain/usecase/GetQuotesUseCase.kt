package com.abanoub.domain.usecase

import com.abanoub.domain.repository.QuotesRepository

class GetQuotesUseCase(private val quotesRepo: QuotesRepository) {

    suspend operator fun invoke() = quotesRepo.getQuotesFromAPI()

}