package com.tashuseyin.calorietracker.navigation

import androidx.navigation.NavController
import com.tashuseyin.core.util.UIEvent

fun NavController.navigate(event: UIEvent.Navigate) {
    this.navigate(event.route)
}