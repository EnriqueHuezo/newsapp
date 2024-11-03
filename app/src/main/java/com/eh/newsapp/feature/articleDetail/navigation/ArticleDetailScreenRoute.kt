package com.eh.newsapp.feature.articleDetail.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eh.newsapp.core.base.BaseScreenWithRoute
import com.eh.newsapp.core.data.utils.UIStateStatus
import com.eh.newsapp.feature.articleDetail.ArticleDetailScreen
import com.eh.newsapp.feature.articleDetail.ArticleDetailViewmodel
import com.eh.newsapp.feature.articleDetail.state.ArticleDetailRouteStateHolder
import com.eh.newsapp.main.ui.components.CustomAppBar
import com.eh.newsapp.main.ui.components.ErrorAlertDialog

@Composable
internal fun ArticleDetailScreenRoute(routeHolder: ArticleDetailRouteStateHolder) =
    BaseScreenWithRoute<ArticleDetailRouteStateHolder, ArticleDetailViewmodel>(
        topBar = {
            CustomAppBar(
                title = "Article detail",
                onNavigationClick = routeHolder.onBackPressed,
                navigationIcon = Icons.AutoMirrored.Filled.ArrowBack
            )
        },
        routeHolder = routeHolder
    ) { viewModel, _ ->
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        LaunchedEffect(Unit) {
            viewModel.getLocalArticle()
        }

        when(val uiState = state) {
            is UIStateStatus.Success -> {
                ArticleDetailScreen(
                    uiState = uiState.data
                )
            }
            is UIStateStatus.Loading -> { Text("Cargando") }
            is UIStateStatus.Error -> {
                val messages = uiState.exception.message.orEmpty()
                ErrorAlertDialog(title = "Ocurrio un error", text = messages)
            }
            is UIStateStatus.Empty -> { Text("Vacio") }
        }
    }