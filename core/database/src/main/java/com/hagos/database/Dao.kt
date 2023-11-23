package com.hagos.database

import androidx.room.Dao
import androidx.room.Insert
import com.hagos.database.models.Crypto

@Dao
interface Dao {
    @Insert
    suspend fun insertCrypto(crypto: Crypto)
}