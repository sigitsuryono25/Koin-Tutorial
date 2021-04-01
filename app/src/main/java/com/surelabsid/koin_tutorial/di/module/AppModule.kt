package com.surelabsid.koin_tutorial.di.module

import android.content.Context
import com.surelabsid.koin_tutorial.BuildConfig
import com.surelabsid.koin_tutorial.data.api.ApiHelper
import com.surelabsid.koin_tutorial.data.api.ApiHelperImpl
import com.surelabsid.koin_tutorial.data.api.ApiServices
import com.surelabsid.koin_tutorial.utils.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

private fun provideOKHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient.Builder()
    .build()

private fun provideRetrofit(okHttpClient: OkHttpClient, BASEURL: String): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASEURL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): ApiServices =
    retrofit.create(ApiServices::class.java)

private fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

val appModule = module {
    single { provideOKHttpClient() }
    single { provideRetrofit(get(), BuildConfig.BASE_URL) }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }
}