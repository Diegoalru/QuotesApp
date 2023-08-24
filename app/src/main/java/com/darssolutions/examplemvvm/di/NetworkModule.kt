package com.darssolutions.examplemvvm.di

import com.darssolutions.examplemvvm.data.network.api.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Módulo Dagger que proporciona las instancias necesarias para la red y las API.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL: String =
        "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"

    /**
     * Proporciona una instancia de Retrofit configurada con la URL base y convertidores.
     *
     * @return Instancia de Retrofit.
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Proporciona una instancia de QuoteApiClient utilizando Retrofit.
     *
     * @param retrofit Instancia de Retrofit configurada.
     * @return Instancia de QuoteApiClient.
     */
    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}
