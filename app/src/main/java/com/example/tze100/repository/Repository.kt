package com.example.tze100.repository

import com.example.tze100.api.ApiService

class Repository(private val api: ApiService) {

    suspend fun getBackendId() = api.getBackendId()

    suspend fun getResultProcess(id: String) = api.getResultProcess(id)

}