package com.hagos.domain.repository

interface CryptoRepository {
    suspend fun insertCrypto()
}