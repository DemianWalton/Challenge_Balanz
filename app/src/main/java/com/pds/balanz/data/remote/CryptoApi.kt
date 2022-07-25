package com.pds.balanz.data.remote

import com.pds.balanz.data.remote.dto.CryptoDto
import retrofit2.http.GET

interface CryptoApi {

    @GET("/api/v3/ticker/24hr")
    suspend fun getCryptos(): List<CryptoDto>


}