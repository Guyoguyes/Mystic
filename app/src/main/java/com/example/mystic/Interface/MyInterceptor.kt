package com.example.mystic.Interface

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "3967712d40msh5bb2caf44639ee1p184039jsna65f069e76a8")
            .build()
        return chain.proceed(request)
    }
}