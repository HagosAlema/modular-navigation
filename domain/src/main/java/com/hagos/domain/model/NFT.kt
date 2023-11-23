package com.hagos.domain.model

data class NFT(
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
    override var contractAddress: String,
    override var parentLUID: String,
    var description: String,
    var customDescription: String,
    var attributes: String,
    var image: String,
    var uniqueId: String,
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
    2,
    contractAddress,
    parentLUID,
    index
)



