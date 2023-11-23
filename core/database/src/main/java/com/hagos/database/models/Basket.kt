package com.hagos.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            childColumns = ["GUID"],
            parentColumns = ["GUID"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        )
    ]
)
data class Basket(
    @PrimaryKey var LUID: String,
    @ColumnInfo(index = true)var GUID: Int,
    var name: String,
    var isRemoved: Boolean,
    var order: Int
)