package com.hagos.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var GUID: Int,
    var usename: String,
    var email: String,
    var password: String,
    var passcode: String,
    var pincode: String,
    var bio: String,
    var phone: String
) {
}