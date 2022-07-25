package com.pds.balanz.di

import com.pds.balanz.data.remote.CryptoApi
import com.pds.balanz.data.repository.CryptoRepositoryImpl
import com.pds.balanz.domain.repository.CryptoRepository
import com.pds.balanz.general.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCryptoApi(): CryptoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(api: CryptoApi): CryptoRepository {
        return CryptoRepositoryImpl(api)
    }

}