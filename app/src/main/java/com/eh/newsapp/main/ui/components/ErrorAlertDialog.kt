package com.eh.newsapp.main.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ErrorAlertDialog(
    title: String,
    text: String,
    icon: ImageVector = Icons.Default.Close
) {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("Cerrar")
                }
            },
            icon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "Error Alert"
                )
            },
            title = {
                Text(title)
            },
            text = {
                Text(text)
            },
        )
    }
}