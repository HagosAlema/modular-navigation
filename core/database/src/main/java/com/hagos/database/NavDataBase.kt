package com.hagos.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hagos.database.models.Basket
import com.hagos.database.models.Crypto
import com.hagos.database.models.NFT
import com.hagos.database.models.NativeCrypto
import com.hagos.database.models.NonNativeCrypto
import com.hagos.database.models.Token
import com.hagos.database.models.UniObject
import com.hagos.database.models.User

@Database(
    entities = [
        User::class,
        Basket::class,
        UniObject::class,
        Crypto::class,
        NativeCrypto::class,
        NonNativeCrypto::class,
        NFT::class,
        Token::class
    ],
    version = 0,
    exportSchema = false
)
abstract class NavDataBase : RoomDatabase() {
    abstract fun dao(): Dao
}