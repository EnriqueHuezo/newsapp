package com.eh.newsapp.main.navigation

import android.util.Log
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.eh.newsapp.feature.articleDetail.navigation.articleDetailsScreen
import com.eh.newsapp.feature.articleDetail.navigation.navigationToArticleDetails
import com.eh.newsapp.feature.home.navigation.homeScreen

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home",
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() }
    ) {
        homeScreen(
            onArticleClick = { articleTitle ->
                navController.navigationToArticleDetails(articleTitle)
            }
        )

        articleDetailsScreen(
            onBack = navController::popBackStack
        )
    }
}