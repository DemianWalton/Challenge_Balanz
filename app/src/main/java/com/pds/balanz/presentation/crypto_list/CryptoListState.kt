package com.pds.balanz.presentation.crypto_list

import com.pds.balanz.domain.model.Crypto

/*data class CryptoListState(
    val isLoading: Boolean = false,
    val cryptos: List<Crypto> = emptyList(),
    val error: String = ""
)*/

sealed class CryptoListState {
    class Success(val result: List<Crypto>) : CryptoListState()
    class Failure(val result: List<Crypto>) : CryptoListState()
    class Loading(val result: List<Crypto>) : CryptoListState()
    object Empty : CryptoListState()
}


