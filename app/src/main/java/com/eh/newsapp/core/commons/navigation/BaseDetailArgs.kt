package com.eh.newsapp.core.commons.navigation

import androidx.lifecycle.SavedStateHandle

abstract class BaseDetailArgs(private val savedStateHandle: SavedStateHandle) {
    abstract fun articleTitleArg(): String

    val articleTitle: String
        get() = savedStateHandle[articleTitleArg()] ?: throw IllegalArgumentException("Missing articleTitle")
}