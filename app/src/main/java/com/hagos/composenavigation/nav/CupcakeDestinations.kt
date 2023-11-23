package com.hagos.composenavigation.nav

import androidx.annotation.StringRes
import com.hagos.composenavigation.R

enum class CupcakeDestinations(@StringRes val title: Int) {
    Start(R.string.cupcake),
    Flavor(R.string.choose_flavor),
    Pickup(R.string.choose_pickup_date),
    Summary(R.string.order_summary),
    Congrats(R.string.congrats),
    AddOrder(R.string.add_menu),
    MyOrder(R.string.myorder_route),
    AddCrypto(R.string.crypto_name),
    EnterPasscode(R.string.crypto_passcode)
}