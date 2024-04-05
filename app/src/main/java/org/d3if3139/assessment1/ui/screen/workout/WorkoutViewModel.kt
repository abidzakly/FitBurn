package org.d3if3139.assessment1.ui.screen.workout

import androidx.lifecycle.ViewModel
import org.d3if3139.assessment1.R
import org.d3if3139.assessment1.model.WorkoutSet

class WorkoutViewModel : ViewModel() {

    val data = getWorkoutSet()

    private fun getWorkoutSet(): List<WorkoutSet> {
        val data = mutableListOf<WorkoutSet>()
//        Abs Workout Women
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_1))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_2))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_3))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_4))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_5))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_6))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_7))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_8))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_9))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_10))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_11))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_12))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_13))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_14))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_15))
        data.add(WorkoutSet(1, 2, R.string.abs_women_workout_16))
//        Chest Workout Women
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_1))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_2))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_3))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_4))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_5))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_6))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_7))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_8))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_9))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_10))
        data.add(WorkoutSet(2, 2, R.string.chest_women_workout_11))
//        Arm Workout Women
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_1))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_2))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_3))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_4))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_5))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_6))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_7))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_8))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_9))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_10))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_11))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_12))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_13))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_14))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_15))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_16))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_17))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_18))
        data.add(WorkoutSet(3, 2, R.string.arm_women_workout_19))
        return data
    }

}