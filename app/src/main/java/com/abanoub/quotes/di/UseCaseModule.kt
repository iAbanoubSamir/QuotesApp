package com.abanoub.quotes.di

import com.abanoub.domain.repository.QuotesRepository
import com.abanoub.domain.usecase.GetQuotesUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    fun provideGetQuotesUseCase(quotesRepository: QuotesRepository): GetQuotesUseCase {
        return GetQuotesUseCase(quotesRepository)
    }

}