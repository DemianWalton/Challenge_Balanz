package com.pds.balanz.domain.use_case.get_cryptos

import com.pds.balanz.data.remote.dto.toCrypto
import com.pds.balanz.domain.model.Crypto
import com.pds.balanz.domain.repository.CryptoRepository
import com.pds.balanz.general.DataEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCryptosUseCase @Inject constructor(
    private val repository: CryptoRepository
) {
    //Execute
    operator fun invoke(): Flow<DataEvent<List<Crypto>>> = flow {
        try {
            emit(DataEvent.Loading<List<Crypto>>())
            val cryptos = repository.getCryptos().map { it.toCrypto() }
            emit(DataEvent.Success<List<Crypto>>(cryptos))
        } catch (e: HttpException) {
            emit(DataEvent.Error<List<Crypto>>(e.localizedMessage ?: "HttpException"))
        } catch (e: IOException) {
            //Conection or server problems
            emit(DataEvent.Error<List<Crypto>>(e.localizedMessage ?: "IOException"))
        }
    }

}