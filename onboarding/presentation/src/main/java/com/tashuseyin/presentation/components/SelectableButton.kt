package com.tashuseyin.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.tashuseyin.core_ui.button

@Composable
fun SelectableButton(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    color: Color,
    selectedTextColor: Color,
    onClick: () -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.button
) {
    OutlinedButton(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(2.dp, color),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(containerColor = if (isSelected) color else Color.Transparent)
    ) {
        Text(
            text = text,
            style = textStyle,
            color = if (isSelected) selectedTextColor else color
        )


    }
}