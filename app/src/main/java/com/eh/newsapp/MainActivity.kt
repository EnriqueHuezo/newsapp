package com.eh.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eh.newsapp.main.navigation.RootNavigation
import com.eh.newsapp.main.ui.theme.NewsappTheme
import org.koin.compose.KoinContext
import org.koin.core.component.KoinComponent

class MainActivity : ComponentActivity(), KoinComponent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsappTheme {
                KoinContext {
                    RootNavigation()
                }
            }
        }
    }
}