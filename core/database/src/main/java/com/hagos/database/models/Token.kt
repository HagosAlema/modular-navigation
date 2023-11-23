package com.hagos.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Basket::class,
            childColumns = ["basketLUID"],
            parentColumns = ["LUID"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
        ForeignKey(
            entity = NativeCrypto::class,
            childColumns = ["parentLUID"],
            parentColumns = ["LUID"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        )
    ]
)
data class Token(
    @PrimaryKey(autoGenerate = true) override var LUID: Int,
    @ColumnInfo(index = true) override var basketLUID: Int,
    override var name: String,
    override var mnemonic: String,
    override var address: String,
    override var publicKey: String?, //public key for
    override var blockchain: String,
    override var cryptoName: String,
    override var customName: String,
    override var balance: Double,
    override var contractAddress: String,
    @ColumnInfo(index = true) override var parentLUID: String,
    var decimal: Int,
    var symbol: String,
    var iconUrl: String,
    override var index: Int
) : NonNativeCrypto(
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
    1,
    contractAddress,
    parentLUID,
    index
)