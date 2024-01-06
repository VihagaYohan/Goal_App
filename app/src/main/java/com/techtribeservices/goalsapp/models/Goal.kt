package com.techtribeservices.goalsapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Goal(
    @StringRes val day: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
