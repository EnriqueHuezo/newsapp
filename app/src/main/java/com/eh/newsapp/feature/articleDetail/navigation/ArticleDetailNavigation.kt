package com.eh.newsapp.feature.articleDetail.navigation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.eh.newsapp.core.commons.navigation.BaseDetailArgs
import com.eh.newsapp.feature.articleDetail.state.ArticleDetailRouteStateHolder

class ArticleDetailArgs(savedStateHandle: SavedStateHandle) : BaseDetailArgs(savedStateHandle) {
    override fun articleTitleArg(): String = "articleTitle"
}

fun NavController.navigationToArticleDetails(articleTitle: String) {
    if (articleTitle.isNotBlank()) {
        this.navigate("Article_details/$articleTitle") {
            launchSingleTop = true
        }
    } else {
        Log.e("", "cannot be blanck dasjofdasnda")
    }
}

fun NavGraphBuilder.articleDetailsScreen(
    onBack: () -> Unit
) {
    composable(
        "Article_details/{articleTitle}",
        arguments = listOf(
            navArgument("articleTitle") { type = NavType.StringType }
        )
    ) {
        ArticleDetailScreenRoute(
            routeHolder = ArticleDetailRouteStateHolder(
                onBackPressed = onBack
            )
        )
    }
}