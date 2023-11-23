package com.hagos.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import kotlin.math.pow

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Basket::class,
            childColumns = ["basketLUID"],
            parentColumns = ["LUID"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        )
    ]
)
data class NativeCrypto(
    @PrimaryKey(autoGenerate = true) override var LUID: Int,
    @ColumnInfo(index = true) override var basketLUID: Int,
    override var name: String,
    override var mnemonic: String,
    override var address: String,
    override var publicKey: String?,//public key for bitcoin, ethereum and polygon;
    override var blockchain: String,
    override var cryptoName: String,
    override var customName: String,
    override var balance: Double,
    var decimal: Int,
    var symbol: String,
    var iconUrl: String,
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
    0,
    index
)



fun NativeCrypto.stringBalance() = this.balance / 10.0.pow(decimal.toDouble())
fun Double.stringBalance(decimal: Int) = this / 10.0.pow(decimal.toDouble())