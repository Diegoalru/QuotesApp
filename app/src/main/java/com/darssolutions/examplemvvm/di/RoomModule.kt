package com.darssolutions.examplemvvm.di

import android.content.Context
import androidx.room.Room
import com.darssolutions.examplemvvm.data.database.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Módulo Dagger que proporciona las instancias necesarias para la base de datos y DAOs.
 */
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "quotes_database"

    /**
     * Proporciona una instancia de QuoteDatabase configurada.
     *
     * @param context Contexto de la aplicación.
     * @return Instancia de QuoteDatabase.
     */
    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): QuoteDatabase {
        return Room.databaseBuilder(
            context,
            QuoteDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    /**
     * Proporciona una instancia de QuoteDao utilizando QuoteDatabase.
     *
     * @param quoteDatabase Instancia de QuoteDatabase.
     * @return Instancia de QuoteDao.
     */
    @Singleton
    @Provides
    fun provideQuoteDao(quoteDatabase: QuoteDatabase) = quoteDatabase.quoteDao()
}
