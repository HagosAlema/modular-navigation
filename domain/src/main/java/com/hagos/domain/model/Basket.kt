package com.hagos.domain.model


data class Basket(
    var LUID: String,
    var GUID: Int,
    var name: String,
    val isRemoved: Boolean,
    var order: Int
)