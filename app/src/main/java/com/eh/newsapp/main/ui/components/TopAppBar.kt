package com.eh.newsapp.main.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String,
    onNavigationClick: () -> Unit = {},
    navigationIcon: ImageVector?,
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            navigationIcon?.let {
                IconButton(
                    onClick = { onNavigationClick() }
                ) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = ""
                    )
                }
            }
        }
    )
}