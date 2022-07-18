package com.bashkir.bookly.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bashkir.bookly.ui.theme.bigPadding

@Composable
fun TopIconsBar(leadingIcon: @Composable () -> Unit, trailingIcon: @Composable () -> Unit, modifier: Modifier = Modifier) = Row(
    modifier.fillMaxWidth().padding(vertical = bigPadding),
    Arrangement.SpaceBetween,
    Alignment.CenterVertically
) {
    leadingIcon()
    trailingIcon()
}