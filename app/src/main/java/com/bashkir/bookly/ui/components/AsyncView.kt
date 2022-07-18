package com.bashkir.bookly.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.bashkir.bookly.data.Async

@Composable
fun <T> AsyncView(async: Async<T>, onSuccess: @Composable (T) -> Unit) = when (async) {
    Async.Loading -> Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        CircularProgressIndicator()
    }
    is Async.Success -> onSuccess(async.value)
    else -> Text(
        "Неудалось загрузить данные :(",
        Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}