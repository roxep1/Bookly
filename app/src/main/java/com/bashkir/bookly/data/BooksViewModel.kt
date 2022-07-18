package com.bashkir.bookly.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bashkir.bookly.data.models.Book
import com.bashkir.bookly.data.models.Image
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val api: BooksApi) : ViewModel() {
    var uiState by mutableStateOf(UiState())

    init {
        getAllData()
    }

    private fun getAllData() {
        uiState = uiState.copy(
            similar = load(api::getSimilar),
            best = load(api::getBest),
            carousel = load(api::getCarousel)
        )
    }

    private fun <T> load(getValue: suspend () -> T): Flow<Async<T>> = flow {
        emit(Async.Loading)
        emit(Async.Success(getValue()))
    }.catch { emit(Async.Error) }
}

sealed class Async<out T> {
    object Uninitialized : Async<Nothing>()
    object Loading : Async<Nothing>()
    data class Success<T>(val value: T) : Async<T>()
    object Error : Async<Nothing>()
}

data class UiState(
    val similar: Flow<Async<List<Image>>> = flow { emit(Async.Uninitialized) },
    val best: Flow<Async<List<Book>>> = flow { emit(Async.Uninitialized) },
    val carousel: Flow<Async<List<Image>>> = flow { emit(Async.Uninitialized) },
)