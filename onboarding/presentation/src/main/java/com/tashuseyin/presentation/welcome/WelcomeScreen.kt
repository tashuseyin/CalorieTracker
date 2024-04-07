package com.tashuseyin.presentation.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tashuseyin.core.R
import com.tashuseyin.core.navigation.Route
import com.tashuseyin.core.util.UIEvent
import com.tashuseyin.core_ui.Spacer16
import com.tashuseyin.presentation.components.ActionButton

@Composable
fun WelcomeScreen(
    onNavigate: (UIEvent.Navigate) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.welcome_text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge
        )
        Spacer16()
        ActionButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.next),
            onClick = { onNavigate.invoke(UIEvent.Navigate(Route.GENDER_SCREEN)) }
        )
    }
}
