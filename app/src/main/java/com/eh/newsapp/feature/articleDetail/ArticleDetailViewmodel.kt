package com.eh.newsapp.feature.articleDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.eh.newsapp.core.base.BaseViewModel
import com.eh.newsapp.core.data.utils.Resource
import com.eh.newsapp.core.data.utils.UIStateStatus
import com.eh.newsapp.core.database.entity.toArticleDetailUIState
import com.eh.newsapp.core.usecases.GetArticleFromLocalUseCase
import com.eh.newsapp.feature.articleDetail.navigation.ArticleDetailArgs
import com.eh.newsapp.feature.articleDetail.state.ArticleDetailUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ArticleDetailViewmodel(
    private val savedStateHandle: SavedStateHandle,
    private val getArticleFromLocalUseCase: GetArticleFromLocalUseCase
): BaseViewModel() {
    private val initialArticleDetailUIState = ArticleDetailUIState()
    private val _uiState: MutableStateFlow<UIStateStatus<ArticleDetailUIState>> =
        MutableStateFlow(UIStateStatus.Empty(initialArticleDetailUIState))
    val uiState = _uiState.asStateFlow()

    fun getLocalArticle() = viewModelScope.launch {
        getArticleFromLocalUseCase
            .execute(args().articleTitle)
            .flowOn(contextProvider.getIoContext())
            .catch { e ->
                _uiState.update { UIStateStatus.Error(e) }
            }
            .collect { article ->
                when(val result = article.status) {
                    is Resource.Status.Loading -> {
                        _uiState.update { UIStateStatus.Loading(message = result.msg) }
                    }

                    is Resource.Status.Success -> {
                        _uiState.update { UIStateStatus.Success(result.data.toArticleDetailUIState()) }
                    }

                    else -> UIStateStatus.Empty(ArticleDetailUIState())
                }
            }
    }

    val articleTitle: String
        get() = args().articleTitle

    private fun args() =
        ArticleDetailArgs(savedStateHandle)
}