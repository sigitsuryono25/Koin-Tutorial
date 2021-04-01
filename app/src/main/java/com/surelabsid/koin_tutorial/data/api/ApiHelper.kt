package com.surelabsid.koin_tutorial.data.api

import com.surelabsid.koin_tutorial.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}