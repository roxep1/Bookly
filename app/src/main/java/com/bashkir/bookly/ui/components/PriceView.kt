package com.bashkir.bookly.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.bashkir.bookly.ui.theme.priceText

@Composable
fun PriceView(price: Float, color: Color = Color.White) =
    Text("$price €", style = priceText, color = color)