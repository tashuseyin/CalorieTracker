package com.tashuseyin.core_ui

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScope.Spacer(length: Dp) {
    Spacer(modifier = Modifier.height(length))
}

@Composable
fun ColumnScope.Spacer(weight: Float) {
    Spacer(modifier = Modifier.weight(weight))
}

@Composable
fun ColumnScope.Spacer4() = Spacer(4.dp)
@Composable
fun ColumnScope.Spacer8() = Spacer(8.dp)
@Composable
fun ColumnScope.Spacer12() = Spacer(12.dp)
@Composable
fun ColumnScope.Spacer16() = Spacer(16.dp)
@Composable
fun ColumnScope.Spacer20() = Spacer(20.dp)
@Composable
fun ColumnScope.Spacer24() = Spacer(24.dp)

@Composable
fun RowScope.Spacer(length: Dp) {
    Spacer(modifier = Modifier.width(length))
}

@Composable
fun RowScope.Spacer(weight: Float) {
    Spacer(modifier = Modifier.weight(weight))
}

@Composable
fun RowScope.Spacer4() = Spacer(4.dp)

@Composable
fun RowScope.Spacer8() = Spacer(8.dp)

@Composable
fun RowScope.Spacer12() = Spacer(12.dp)

@Composable
fun RowScope.Spacer16() = Spacer(16.dp)

@Composable
fun RowScope.Spacer20() = Spacer(20.dp)

@Composable
fun RowScope.Spacer24() = Spacer(24.dp)


