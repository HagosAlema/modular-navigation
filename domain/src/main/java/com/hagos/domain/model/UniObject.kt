package com.hagos.domain.model

open class UniObject(
    open val LUID: Int,
    open val basketLUID: Int,
    open val name: String,
    open val objectType: Int,
    open val index: Int,
)