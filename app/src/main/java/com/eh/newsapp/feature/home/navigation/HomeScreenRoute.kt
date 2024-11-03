package com.eh.newsapp.feature.home.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eh.newsapp.core.base.BaseScreenWithRoute
import com.eh.newsapp.core.data.utils.UIStateStatus
import com.eh.newsapp.feature.home.HomeScreen
import com.eh.newsapp.feature.home.HomeViewModel
import com.eh.newsapp.feature.home.state.HomeRouteStateHolder
import com.eh.newsapp.feature.home.state.HomeScreenViewStateHolder
import com.eh.newsapp.main.ui.components.ErrorAlertDialog

@Composable
internal fun HomeScreenRoute(routeHolder: HomeRouteStateHolder) =
    BaseScreenWithRoute<HomeRouteStateHolder, HomeViewModel>(
        topBar = {},
        routeHolder = routeHolder
    ) { viewModel, navigation ->
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        LaunchedEffect(Unit) {
            viewModel.getTopHeadlinesArticles()
        }

        when(val uiState = state) {
            is UIStateStatus.Success -> { HomeScreen(
                uiState = uiState.data,
                viewState = HomeScreenViewStateHolder(onArticleClick = navigation.onArticleClick)
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