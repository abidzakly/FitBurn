package org.d3if3139.assessment1.ui.screen.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.d3if3139.assessment1.R
import org.d3if3139.assessment1.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    val radioOptions =
        listOf(stringResource(id = R.string.male), stringResource(id = R.string.female))
    var gender by rememberSaveable { mutableStateOf(radioOptions[0]) }
    var genderId by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.splash_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(300.dp)
        )
        Text(text = stringResource(R.string.gender_select), modifier = Modifier.padding(16.dp))
        Row {
            radioOptions.forEach { text ->
                GenderOption(
                    label = text,
                    isSelected = gender == text,
                    modifier = Modifier
                        .selectable(
                            selected = gender == text,
                            onClick = {
                                gender = text
                            },
                            role = Role.RadioButton
                        )
                        .weight(1f)
                        .padding(16.dp)
                )
            }
        }
        Button(
            onClick = {
                if (gender == "Male") {
                    genderId = 1
                } else {
                    genderId = 2
                }
                navController.popBackStack()
                navController.navigate("${Screen.Dashboard.route}/$genderId")
            },
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 56.dp, vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.lilac),
                contentColor = colorResource(R.color.dark_purple)
            )
        ) {

            Text(text = stringResource(R.string.enter))
        }
        BackHandler(enabled = true) {
            (context as Activity).finish()
        }
    }
}

@Composable
fun GenderOption(label: String, isSelected: Boolean, modifier: Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton( selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(8.dp)
        )
    }
}

