package com.darssolutions.examplemvvm.core

import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val API = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/"

    fun getRetrofit(): retrofit2.Retrofit {
        return retrofit2.Retrofit.Builder()
            .baseUrl(API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
