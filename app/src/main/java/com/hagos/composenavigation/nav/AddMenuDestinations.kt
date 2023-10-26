package com.hagos.composenavigation.nav

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.hagos.composenavigation.R

enum class AddMenuDestinations(@StringRes val title: Int, icon: ImageVector? = null) {
    MenuName(R.string.menu_name),
    MenuPrice(R.string.menu_price),
    MenuDuration(R.string.menu_duration),
    MenuSummary(R.string.menu_summary)
}