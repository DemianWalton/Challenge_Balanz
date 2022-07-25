package com.pds.balanz.presentation.crypto_list


import GetCryptosUseCase
import com.pds.balanz.general.DataEvent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val getCryptoUseCase: GetCryptosUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<CryptoListState>(CryptoListState.Empty)
    val state: StateFlow<CryptoListState> = _state

    init {
        getCryptos()
    }

    private fun getCryptos() {
        getCryptoUseCase().onEach { result ->
            when (result) {
                is DataEvent.Success -> {
                    _state.value = CryptoListState.Success(result.data ?: emptyList())
                }
                is DataEvent.Error -> {
                    _state.value = CryptoListState.Failure(result.data ?: emptyList())
                }
                is DataEvent.Loading -> {
                    _state.value = CryptoListState.Loading(result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}