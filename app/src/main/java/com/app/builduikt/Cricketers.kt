package com.app.builduikt

import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cricketers(
    @DrawableRes val profile: Int,
    @StringRes var playerName: Int,
    @StringRes var playerSpecialization: Int,
    @StringRes var playerTeam: Int
)
