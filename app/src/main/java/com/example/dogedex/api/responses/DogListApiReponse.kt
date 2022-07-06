package com.example.dogedex.api.responses

import com.squareup.moshi.Json

class DogListApiReponse(
    val message: String,
    @field:Json(name = "is_success") val isSuccess: Boolean,
    val data: DogListResponse
)