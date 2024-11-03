package com.eh.newsapp.core.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
inline fun <H, reified V : ViewModel> BaseScreenWithRoute(
    modifier: Modifier = Modifier,
    viewModel: V = koinViewModel(),
    routeHolder: H,
    noinline topBar: @Composable () -> Unit = {},
    noinline floatingActionButton: @Composable () -> Unit = {},
    crossinline content: @Composable (V, H) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        floatingActionButton = floatingActionButton,
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .consumeWindowInsets(paddingValues)
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                content(viewModel, routeHolder)
            }
        }
    )
}

@Composable
inline fun <reified V : ViewModel> BaseScreenWithRoute(
    modifier: Modifier = Modifier,
    viewModel: V = koinViewModel(),
    noinline topBar: @Composable () -> Unit = {},
    noinline floatingActionButton: @Composable () -> Unit = {},
    crossinline content: @Composable (V) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        floatingActionButton = floatingActionButton,
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .consumeWindowInsets(paddingValues)
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                content(viewModel)
            }
        }
    )
}