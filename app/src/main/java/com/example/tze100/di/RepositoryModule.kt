package com.example.tze100.di

import com.example.tze100.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    factory { Repository(get()) }
}