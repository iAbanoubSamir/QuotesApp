package com.abanoub.quotes.di

import com.abanoub.data.remote.QuotesApiService
import com.abanoub.data.repository.QuotesRepositoryImpl
import com.abanoub.domain.repository.QuotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideQuotesRepository(apiService: QuotesApiService): QuotesRepository {
        return QuotesRepositoryImpl(apiService)
    }

}