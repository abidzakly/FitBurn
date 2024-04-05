package org.d3if3139.assessment1.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ExerciseList(
    val type: Int,
    @StringRes val title: Int,
    val gender: Int,
    @DrawableRes val imageResourceId: Int
)
