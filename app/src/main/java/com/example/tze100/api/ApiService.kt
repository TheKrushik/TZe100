package com.example.tze100.api

import com.example.tze100.model.IdObject
import com.example.tze100.model.ProcessObject
import retrofit2.http.POST
import retrofit2.http.Path

const val BASE_URL = "http://www.mocky.io/"

interface ApiService {

    @POST("v2/5e78030f3300009e6b09a124")
    suspend fun getBackendId(): IdObject

//    @POST("/v2/5e77fed63300009e6b09a116")
    @POST("/v2/{id}")
    suspend fun getResultProcess(@Path("id") id: String): ProcessObject

}