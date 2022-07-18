package com.bashkir.bookly.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.bashkir.bookly.data.models.Rate
import com.bashkir.bookly.ui.theme.rateAmountText
import com.bashkir.bookly.ui.theme.rateText

@Composable
fun RateView(rate: Rate) = Row(verticalAlignment = Alignment.CenterVertically) {
    Text(rate.score.toString(), style = rateText)
    Text(" (${rate.amount})", style = rateAmountText)
}