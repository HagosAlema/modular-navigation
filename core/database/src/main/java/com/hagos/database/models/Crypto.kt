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
        )
    ]
)
open class Crypto(
    @PrimaryKey override var LUID: Int,
    @ColumnInfo(index = true) override var basketLUID: Int,
    override var name: String,
    open var mnemonic: String,
    open var address: String,
    open var publicKey: String?,
    open var blockchain: String,
    open var cryptoName: String,
    open var customName: String,
    open var balance: Double,
    open var cryptoType: Int,
    override var index: Int

): UniObject (
    LUID,
    basketLUID,
    name,
    1,
    index
)