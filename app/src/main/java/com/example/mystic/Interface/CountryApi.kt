package com.example.mystic.Interface

import com.example.mystic.Model.Country
import com.example.mystic.Model.CountryDebug
import com.squareup.okhttp.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CountryApi {


    @GET("countries")
    suspend fun getCountrys(): Response<CountryDebug>
}