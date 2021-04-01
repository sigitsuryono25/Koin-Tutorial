package com.surelabsid.koin_tutorial.data.repository

import com.surelabsid.koin_tutorial.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}