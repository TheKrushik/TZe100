package com.example.tze100.ui.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tze100.repository.Repository
import com.example.tze100.ui.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressViewModel(private val repository: Repository) : BaseViewModel() {

    private val _resultProcess = MutableLiveData<Boolean>()
    val resultProcess: LiveData<Boolean>
        get() = _resultProcess


    fun postResultProcess(id: String) {
        ioScope.launch {
            try {
                delay(3000)
                val result = repository.getResultProcess(id)
                _resultProcess.postValue(result.result)
            } catch (e: Exception) {
                e.printStackTrace()
                _resultProcess.postValue(false)
            }
        }
    }
}