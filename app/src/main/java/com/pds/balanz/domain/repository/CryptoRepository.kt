package com.pds.balanz.domain.repository

import com.pds.balanz.data.remote.dto.CryptoDto

interface CryptoRepository {

    suspend fun getCryptos():List<CryptoDto>
}