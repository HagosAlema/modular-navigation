package com.hagos.domain.model

data class User(
    var GUID: Int,
    var usename: String,
    var email: String,
    var password: String,
    var passcode: String,
    var pincode: String,
    var bio: String,
    var phone: String
)