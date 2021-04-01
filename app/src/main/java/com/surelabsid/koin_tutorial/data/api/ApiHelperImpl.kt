package com.surelabsid.koin_tutorial.data.api

import com.surelabsid.koin_tutorial.data.model.User
import retrofit2.Response

class ApiHelperImpl(private val apiServices: ApiServices): ApiHelper {
    override suspend fun getUsers(): Response<List<User>> = apiServices.getUsers()
}