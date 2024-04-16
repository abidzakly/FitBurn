package org.d3if3139.assessment1.ui.screen.dashboard

import androidx.lifecycle.ViewModel
import org.d3if3139.assessment1.R
import org.d3if3139.assessment1.model.ExerciseList

class DashboardViewModel : ViewModel() {

    val data = getExerciseList()

    private fun getExerciseList(): List<ExerciseList> {
        val data = mutableListOf<ExerciseList>()
        data.add(ExerciseList(1, R.string.abs_exercise, 1, R.drawable.abs_men))
        data.add(ExerciseList(2, R.string.chest_exercise, 1, R.drawable.chest_men))
        data.add(ExerciseList(3, R.string.arm_exercise, 1, R.drawable.arm_men))
        data.add(ExerciseList(1, R.string.abs_exercise, 2, R.drawable.abs_women))
        data.add(ExerciseList(2, R.string.chest_exercise, 2, R.drawable.chest_women))
        data.add(ExerciseList(3, R.string.arm_exercise, 2, R.drawable.arm_women))
        return data
    }
}