package com.drawstep.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.drawstep.app.ui.screens.HomeScreen
import com.drawstep.app.ui.screens.LessonViewerScreen
import com.drawstep.app.ui.screens.SplashScreen

private object Routes {
    const val SPLASH = "splash"
    const val HOME = "home"
    const val LESSON = "lesson/{lessonId}"
    fun lesson(id: String) = "lesson/$id"
}

@Composable
fun DrawStepNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen(onFinished = {
                navController.navigate(Routes.HOME) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                }
            })
        }
        composable(Routes.HOME) {
            HomeScreen(onOpenLesson = { id -> navController.navigate(Routes.lesson(id)) })
        }
        composable(
            route = Routes.LESSON,
            arguments = listOf(navArgument("lessonId") { type = NavType.StringType })
        ) { entry ->
            val id = entry.arguments?.getString("lessonId").orEmpty()
            LessonViewerScreen(lessonId = id, onBack = { navController.popBackStack() })
        }
    }
}
