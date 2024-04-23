package com.tashuseyin.calorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tashuseyin.calorietracker.navigation.navigate
import com.tashuseyin.calorietracker.ui.theme.CalorieTrackerTheme
import com.tashuseyin.core.navigation.Route
import com.tashuseyin.presentation.activity.ActivityScreen
import com.tashuseyin.presentation.age.AgeScreen
import com.tashuseyin.presentation.gender.GenderScreen
import com.tashuseyin.presentation.goal.GoalScreen
import com.tashuseyin.presentation.height.HeightScreen
import com.tashuseyin.presentation.nutrient_goal.NutrientGoalScreen
import com.tashuseyin.presentation.weight.WeightScreen
import com.tashuseyin.presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalorieTrackerTheme {
                val navController = rememberNavController()
                val snackbarHostState = remember { SnackbarHostState() }
                Scaffold(
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(
                        modifier = Modifier.padding(it),
                        navController = navController,
                        startDestination = Route.WELCOME_SCREEN
                    ) {
                        composable(route = Route.WELCOME_SCREEN) {
                            WelcomeScreen(onNavigate = navController::navigate)
                        }
                        composable(route = Route.GENDER_SCREEN) {
                            GenderScreen(onNavigate = navController::navigate)
                        }
                        composable(route = Route.AGE_SCREEN) {
                            AgeScreen(
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(route = Route.HEIGHT_SCREEN) {
                            HeightScreen(
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(route = Route.WEIGHT_SCREEN) {
                            WeightScreen(
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(route = Route.ACTIVITY_SCREEN) {
                            ActivityScreen(onNavigate = navController::navigate)
                        }
                        composable(route = Route.GOAL_SCREEN) {
                            GoalScreen(onNavigate = navController::navigate)
                        }
                        composable(route = Route.NUTRIENT_GOAL_SCREEN) {
                            NutrientGoalScreen(
                                snackbarHostState = snackbarHostState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(route = Route.TRACKER_OVERVIEW_SCREEN) {}
                        composable(route = Route.SEARCH_SCREEN) {}
                    }
                }
            }
        }
    }
}

