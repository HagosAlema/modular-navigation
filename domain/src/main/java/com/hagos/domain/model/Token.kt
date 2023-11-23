package com.hagos.domain.model

data class Token(
    override var LUID: Int,
    override var basketLUID: Int,
    override val name: String,
    override val mnemonic: String,
    override var address: String,
    override var publicKey: String?, //public key for
    override var blockchain: String,
    override var cryptoName: String,
    override var customName: String,
    override var balance: Double,
    override var contractAddress: String,
    override var parentLUID: String,
    var decimal: Int,
    var symbol: String,
    var iconUrl: String,
    override val index: Int
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