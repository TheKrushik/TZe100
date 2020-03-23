package com.example.tze100.di

import com.example.tze100.ui.progress.ProgressViewModel
import com.example.tze100.ui.start.StartViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { StartViewModel(get()) }
    viewModel { ProgressViewModel(get()) }
}
