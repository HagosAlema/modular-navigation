package com.hagos.domain.model

open class NonNativeCrypto(
    override var LUID: Int,
    override var basketLUID: Int,
    override val name: String,
    override val mnemonic: String,
    override var address: String,
    override var publicKey: String?,
    override var blockchain: String,
    override var cryptoName: String,
    override var customName: String,
    override var balance: Double,
    override var cryptoType: Int,
    open var contractAddress: String,
    open var parentLUID: String,
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
    cryptoType,
    index
)
