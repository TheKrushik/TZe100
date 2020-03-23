package com.example.tze100.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel: ViewModel() {

    protected val uiScope = CoroutineScope(Dispatchers.Main)
    protected val ioScope = CoroutineScope(Dispatchers.Default)

    override fun onCleared() {
        super.onCleared()
        uiScope.coroutineContext.cancel()
        ioScope.coroutineContext.cancel()
    }
}