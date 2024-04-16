package org.d3if3139.assessment1.model

import androidx.annotation.StringRes

data class WorkoutSet(
    val typeId: Int,
    val genderId: Int,
    @StringRes val name: Int,
    var isFinished: Boolean
)
