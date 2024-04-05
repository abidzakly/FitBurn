package org.d3if3139.assessment1.ui.screen.calorie

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.d3if3139.assessment1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalorieScreen(navController: NavController, typeId: Int, genderId: Int) {
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(
                            R.string.back
                        )
                    )
                }
            },
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = colorResource(R.color.lilac),
                titleContentColor = colorResource(R.color.dark_purple)
            )
        )
    }
    ) { padding ->
        ScreenContent(Modifier.padding(padding), typeId, genderId)
    }
}

@Composable
fun ScreenContent(modifier: Modifier, typeId: Int, genderId: Int) {
    var met by rememberSaveable { mutableFloatStateOf(0f) }

    var weight by rememberSaveable { mutableStateOf("") }
    var weightError by rememberSaveable { mutableStateOf(false) }

    var duration by rememberSaveable { mutableStateOf("") }
    var durationError by rememberSaveable { mutableStateOf(false) }

    var category by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }

    when {
        typeId == 1 -> category = "Abs Workout"
        typeId == 2 -> category = "Chest Workout"
        typeId == 3 -> category = "Arm Workout"
    }
    when {
        genderId == 1 -> {
            gender = "Men"
            met = 3.5f
        }

        genderId == 2 -> {
            gender = "Women"
            met = 3.0f
        }
    }


    var caloriePerMinute by rememberSaveable {
        mutableFloatStateOf(0f)
    }
    var calorieTotal by rememberSaveable {
        mutableFloatStateOf(0f)
    }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.calorie_title),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text(text = stringResource(R.string.weight)) },
            trailingIcon = { IconPicker(weightError, "kg") },
            supportingText = { ErrorHint(weightError) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ), modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = duration,
            onValueChange = { duration = it },
            label = { Text(text = stringResource(R.string.duration)) },
            trailingIcon = { IconPicker(durationError, "s") },
            supportingText = { ErrorHint(durationError) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ), modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                weightError = (weight == "" || weight == "0")
                durationError = (duration == "" || duration == "0")
                if (weightError || durationError) return@Button

                caloriePerMinute = calculateCPM(met.toFloat(), weight.toFloat())
                calorieTotal = calculateCT(caloriePerMinute.toFloat(), duration.toFloat())
            },
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(text = stringResource(R.string.calculate))
        }
        if (caloriePerMinute != 0f) {
            Divider(modifier = Modifier.padding(vertical = 8.dp), thickness = 1.dp)
            Text(
                text = stringResource(R.string.calorie_per_minute, caloriePerMinute),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(R.string.calorie_total, calorieTotal),
                style = MaterialTheme.typography.titleLarge
            )
            Button(
                onClick = {
                    shareData(
                        context = context,
                        message = context.getString(
                            R.string.share_template,
                            met.toString(),
                            caloriePerMinute.toString(),
                            duration,
                            calorieTotal,
                            category + " " + gender
                        )
                    )
                },
                modifier = Modifier.padding(top = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(text = stringResource(R.string.share))
            }
        }
    }
}

@Composable
fun GenderOption(label: String, isSelected: Boolean, modifier: Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun IconPicker(isError: Boolean, unit: String) {
    if (isError) {
        Icon(imageVector = Icons.Filled.Warning, contentDescription = null)
    } else {
        Text(text = unit)
    }
}

@Composable
fun ErrorHint(isError: Boolean) {
    if (isError) {
        Text(text = stringResource(R.string.input_invalid))
    }
}

private fun calculateCPM(met: Float, weight: Float): Float {
    return met * weight * 0.0175f
}

private fun calculateCT(cpm: Float, duration: Float): Float {
    return cpm * duration
}


private fun shareData(context: Context, message: String) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, message)
    }
    if (shareIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(shareIntent)
    }
}
