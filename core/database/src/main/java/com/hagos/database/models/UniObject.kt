package com.hagos.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            childColumns = ["basketLUID"],
            parentColumns = ["LUID"],
            entity = Basket::class
        )
    ]
)
open class UniObject(
    @PrimaryKey(autoGenerate = true) open val LUID: Int,
    @ColumnInfo(index = true) open var basketLUID: Int,
    open var name: String,
    open var objectType: Int,
    open var index: Int,
)