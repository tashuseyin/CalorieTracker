package com.tashuseyin.presentation.age

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tashuseyin.core.R
import com.tashuseyin.core.util.UIEvent
import com.tashuseyin.core_ui.Spacer8
import com.tashuseyin.core_ui.h3
import com.tashuseyin.presentation.components.ActionButton
import com.tashuseyin.presentation.components.UnitTextField

@Composable
fun AgeScreen(
    snackbarHostState: SnackbarHostState,
    onNavigate: (UIEvent.Navigate) -> Unit,
    viewModel: AgeViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.Navigate -> onNavigate.invoke(event)
                is UIEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(message = event.message.asString(context = context))
                }

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
                text = stringResource(id = R.string.whats_your_age),
                style = MaterialTheme.typography.h3
            )
            Spacer8()
            UnitTextField(
                value = viewModel.age,
                onValueChange = viewModel::onAgeEnter,
                unit = stringResource(id = R.string.years)
            )
        }
        ActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextClick
        )
    }

}
