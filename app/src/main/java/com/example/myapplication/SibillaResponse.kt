package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class SibillaResponse____(
    var response: List<String>
)

data class SibillaResponse(
    var response: List<Response>
)

data class Response(
    var from: String,
    var query: String,
    var values: List<List<String>>
)
