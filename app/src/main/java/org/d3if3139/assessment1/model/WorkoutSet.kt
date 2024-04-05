package org.d3if3139.assessment1.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.util.Timer

data class WorkoutSet(
    val typeId: Int,
    val genderId: Int,
    @StringRes val name: Int,
)
