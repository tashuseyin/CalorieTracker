package com.tashuseyin.core_ui

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography.body1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    }

val Typography.button: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W500,
            fontSize = 20.sp,
        )
    }

val Typography.caption: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    }

val Typography.h1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 30.sp
        )
    }

val Typography.h2: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 26.sp
        )
    }

val Typography.h3: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp
        )
    }

val Typography.h4: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )
    }

val Typography.h5: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
    }