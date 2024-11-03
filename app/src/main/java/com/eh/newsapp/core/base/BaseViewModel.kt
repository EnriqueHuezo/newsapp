package com.eh.newsapp.core.base

import androidx.lifecycle.ViewModel
import com.eh.newsapp.core.commons.ICoroutineContextProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel: ViewModel(), KoinComponent {
    val contextProvider by inject<ICoroutineContextProvider>()
}