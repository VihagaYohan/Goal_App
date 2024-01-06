package com.techtribeservices.goalsapp.repository

import androidx.compose.ui.res.stringResource
import com.techtribeservices.goalsapp.models.Goal
import com.techtribeservices.goalsapp.R

object GoalsService {
    val goals = listOf<Goal>(
        Goal(
            day = R.string.day1,
            title = R.string.title1,
            description = R.string.description1,
            image = R.drawable.image_1
        ),
        Goal(
            day = R.string.day2,
            title = R.string.title2,
            description = R.string.description2,
            image = R.drawable.image_2
        ),
        Goal(
            day = R.string.day1,
            title = R.string.title1,
            description = R.string.description1,
            image = R.drawable.image_3
        )
    )
}