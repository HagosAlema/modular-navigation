package com.hagos.domain.model

import kotlin.math.pow

data class NativeCrypto(
    override var LUID: Int,
    override var basketLUID: Int,
    override val name: String,
    override val mnemonic: String,
    override var address: String,
    override var publicKey: String?,//public key for bitcoin, ethereum and polygon;
    override var blockchain: String,
    override var cryptoName: String,
    override var customName: String,
    override var balance: Double,
    var decimal: Int,
    var symbol: String,
    var iconUrl: String,
    override val index: Int
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