package com.pds.balanz.data.repository

import com.pds.balanz.data.remote.CryptoApi
import com.pds.balanz.data.remote.dto.CryptoDto
import com.pds.balanz.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val api: CryptoApi
) : CryptoRepository {

    override suspend fun getCryptos(): List<CryptoDto> {
        return api.getCryptos()
    }
}