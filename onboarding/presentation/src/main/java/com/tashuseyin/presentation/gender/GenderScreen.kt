package com.tashuseyin.presentation.gender

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tashuseyin.core.R
import com.tashuseyin.core.domain.model.Gender
import com.tashuseyin.core.util.UIEvent
import com.tashuseyin.core_ui.DarkGreen
import com.tashuseyin.core_ui.Spacer8
import com.tashuseyin.core_ui.h3
import com.tashuseyin.presentation.components.ActionButton
import com.tashuseyin.presentation.components.SelectableButton

@Composable
fun GenderScreen(
    onNavigate: (UIEvent.Navigate) -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.Navigate -> onNavigate.invoke(event)
                else -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_gender),
                style = MaterialTheme.typography.h3
            )
            Spacer8()
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.male),
                    isSelected = viewModel.selectedGender is Gender.Male,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGenderClick(Gender.Male)
                    }
                )
                Spacer8()
                SelectableButton(
                    text = stringResource(id = R.string.female),
                    isSelected = viewModel.selectedGender is Gender.Female,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGenderClick(Gender.Female)
                    }
                )
            }
        }
        ActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextClick
        )
    }
}
