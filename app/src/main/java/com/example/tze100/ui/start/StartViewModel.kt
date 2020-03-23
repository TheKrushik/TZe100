package com.example.tze100.ui.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tze100.api.NetworkState
import com.example.tze100.repository.Repository
import com.example.tze100.ui.BaseViewModel
import kotlinx.coroutines.launch

class StartViewModel(private val repository: Repository) : BaseViewModel() {

    private val _backendId = MutableLiveData<String>()
    val backendId: LiveData<String>
        get() = _backendId

    private val _status = MutableLiveData<NetworkState>()
    val status: LiveData<NetworkState>
        get() = _status


    fun postBackendId() {
        ioScope.launch {
            try {
                _status.postValue(NetworkState.RUNNING)
                val result = repository.getBackendId()
                _backendId.postValue(result.id)
                _status.postValue(NetworkState.SUCCESS)
            } catch (e: Exception) {
                e.printStackTrace()
                _status.postValue(NetworkState.FAILED)
            }
        }
    }

}