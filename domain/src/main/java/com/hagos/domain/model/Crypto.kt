package com.hagos.domain.model


open class Crypto(
    override var LUID: Int = 0,
    override var basketLUID: Int = 1,
    override val name: String = "",
    open val mnemonic: String = "",
    open val address: String = "",
    open val publicKey: String? = null,
    open val blockchain: String = "",
    open val cryptoName: String = "",
    open val customName: String = "",
    open val balance: Double = 0.0,
    open val cryptoType: Int = 0,
    override val index: Int = 0

): UniObject (
    LUID,
    basketLUID,
    name,
    1,
    index
)