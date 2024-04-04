package com.tashuseyin.calorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tashuseyin.calorietracker.navigation.navigate
import com.tashuseyin.calorietracker.ui.theme.CalorieTrackerTheme
import com.tashuseyin.core.navigation.Route
import com.tashuseyin.presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalorieTrackerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.WELCOME_SCREEN) {
                    composable(route = Route.WELCOME_SCREEN) {
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(route = Route.AGE_SCREEN) {}
                    composable(route = Route.GENDER_SCREEN) {}
                    composable(route = Route.HEIGHT_SCREEN) {}
                    composable(route = Route.WEIGHT_SCREEN) {}
                    composable(route = Route.NUTRIENT_GOAL_SCREEN) {}
                    composable(route = Route.GOAL_SCREEN) {}
                    composable(route = Route.ACTIVITY) {}
                    composable(route = Route.TRACKER_OVERVIEW_SCREEN) {}
                    composable(route = Route.SEARCH_SCREEN) {}
                }
            }
        }
    }
}

