package com.eh.newsapp.feature.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.eh.newsapp.core.base.BaseViewModel
import com.eh.newsapp.core.data.utils.Resource
import com.eh.newsapp.core.data.utils.UIStateStatus
import com.eh.newsapp.core.usecases.GetArticlesFromRemoteUseCase
import com.eh.newsapp.feature.home.state.ArticleCardUIState
import com.eh.newsapp.feature.home.state.HomeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
     private val getArticlesFromRemoteUseCase: GetArticlesFromRemoteUseCase
): BaseViewModel() {
     private val initialHomeUIState = HomeUIState()
     private val _uiState: MutableStateFlow<UIStateStatus<HomeUIState>> =
          MutableStateFlow(UIStateStatus.Empty(initialHomeUIState))
     val uiState = _uiState.asStateFlow()

     fun getTopHeadlinesArticles() = viewModelScope.launch {
          getArticlesFromRemoteUseCase.execute()
               .flowOn(contextProvider.getIoContext())
               .catch { e ->
                    _uiState.update {
                         UIStateStatus.Error(
                              exception = e
                         )
                    }
               }
               .collect { articles ->
                    when(articles.status) {
                         is Resource.Status.Loading -> {
                              _uiState.update {
                                   UIStateStatus.Loading(message = articles.status.msg)
                              }
                         }

                         is Resource.Status.Success -> {
                              val getArticles = articles.status.data
                              val articleCards = getArticles.filter { it.articleEntity.title != "[Removed]" }.map {
                                   // Unas imagenes no se pueden extraer por temas de paginas no seguras
                                   ArticleCardUIState(
                                        id = it.sourceEntity.sourceId,
                                        nameSource = it.sourceEntity.name,
                                        title = it.articleEntity.title,
                                        author = it.articleEntity.author,
                                        description = it.articleEntity.description,
                                        url = it.articleEntity.url,
                                        urlToImage = it.articleEntity.urlToImage,
                                        publishedAt = it.articleEntity.publishedAt,
                                        content = it.articleEntity.content
                                   )
                              }
                              _uiState.update {
                                   UIStateStatus.Success(
                                        data = HomeUIState(
                                             articles = articleCards
                                        )
                                   )
                              }
                         }

                         Resource.Status.EmptySuccess -> {

                         }

                         is Resource.Status.Error -> {

                         }
                    }
               }
     }
}