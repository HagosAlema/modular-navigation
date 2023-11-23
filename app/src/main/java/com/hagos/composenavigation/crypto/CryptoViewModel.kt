package com.hagos.composenavigation.crypto

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hagos.domain.model.Crypto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(): ViewModel(

) {

    var state by mutableStateOf(AddCryptoUiState())
    fun setCryptoName(name: String){
        viewModelScope.launch {
            state = state.copy(
                crypto = Crypto(name = name)
            )
        }
    }
    fun createCrypto(name: String){
        viewModelScope.launch {

        }
    }
}

data class AddCryptoUiState(
    val crypto: Crypto? = Crypto(),
    val loading: Boolean = false
)