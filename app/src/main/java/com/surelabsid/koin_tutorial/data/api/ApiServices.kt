package com.surelabsid.koin_tutorial.data.api

import com.surelabsid.koin_tutorial.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}