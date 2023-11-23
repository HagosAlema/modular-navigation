package com.hagos.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            childColumns = ["basketLUID"],
            parentColumns = ["LUID"],
            entity = Basket::class
        ),
        ForeignKey(
            childColumns = ["parentLUID"],
            parentColumns = ["LUID"],
            entity = NativeCrypto::class
        )
    ]
)
open class NonNativeCrypto(
    @PrimaryKey (autoGenerate = true) override var LUID: Int,
    @ColumnInfo(index = true) override var basketLUID: Int,
    override var name: String,
    override var mnemonic: String,
    override var address: String,
    override var publicKey: String?,
    override var blockchain: String,
    override var cryptoName: String,
    override var customName: String,
    override var balance: Double,
    override var cryptoType: Int,
    open var contractAddress: String,
    @ColumnInfo(index = true) open var parentLUID: String,
    override var index: Int
) : Crypto(
    LUID,
    basketLUID,
    name,
    mnemonic,
    address,
    publicKey,
    blockchain,
    cryptoName,
    customName,
    balance,
    cryptoType,
    index
)
