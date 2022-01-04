package com.example.mystic.Model

data class CountryDebug(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: List<Any>,
    val response: List<Response>,
    val results: Int
)