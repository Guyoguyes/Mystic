package com.example.mystic.Interface

import com.example.mystic.Model.Country
import com.squareup.okhttp.Call
import com.squareup.okhttp.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CountryApi {

//    @GET("country")
//    Call
    @GET("country")
    suspend fun getCountrys(): retrofit2.Response<List<Country>>
}