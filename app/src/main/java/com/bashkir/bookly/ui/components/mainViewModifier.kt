package com.bashkir.bookly.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.bashkir.bookly.ui.theme.Background
import com.bashkir.bookly.ui.theme.bigPadding

fun Modifier.mainViewModifier(): Modifier = fillMaxSize()
    .background(Background)
    .padding(horizontal = bigPadding)