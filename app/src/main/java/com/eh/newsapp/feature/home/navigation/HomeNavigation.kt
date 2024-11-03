package com.eh.newsapp.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.eh.newsapp.feature.home.state.HomeRouteStateHolder

fun NavController.navigationToHome(navOptions: NavOptions? = null) {
    this.navigate("Home", navOptions)
}

fun NavGraphBuilder.homeScreen(
    onArticleClick: (articleTitle: String) -> Unit
) {
    composable("Home") {
        HomeScreenRoute(
            routeHolder = HomeRouteStateHolder(
                onArticleClick = onArticleClick
            )
        )
    }
}