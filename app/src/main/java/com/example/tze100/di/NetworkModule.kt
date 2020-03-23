package com.example.tze100.di

import com.example.tze100.BuildConfig
import com.example.tze100.api.ApiService
import com.example.tze100.api.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        HttpLoggingInterceptor()
            .setLevel(
                if (BuildConfig.DEBUG) Level.BODY else Level.NONE
            )
    }

    single {
        OkHttpClient.Builder()
                .addInterceptor(get<HttpLoggingInterceptor>())
                .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory{ get<Retrofit>().create(ApiService::class.java) }
}