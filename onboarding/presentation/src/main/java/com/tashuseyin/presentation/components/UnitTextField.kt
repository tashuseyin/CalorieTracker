package com.tashuseyin.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.tashuseyin.core_ui.Spacer4

@Composable
fun UnitTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    unit: String,
    textStyle: TextStyle = TextStyle(
        color = MaterialTheme.colorScheme.primaryContainer,
        fontSize = 70.sp
    )
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = value,
            onValueChange = { onValueChange.invoke(it) },
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .alignBy(LastBaseline)
        )
        Spacer4()
        Text(text = unit, modifier = Modifier.alignBy(LastBaseline) )

    }
}