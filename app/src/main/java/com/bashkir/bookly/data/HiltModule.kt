package com.bashkir.bookly.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Singleton
    @Provides
    fun provideApi(): BooksApi = Retrofit.Builder()
        .baseUrl(BooksApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(BooksApi::class.java)
}