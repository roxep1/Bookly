package com.bashkir.bookly.ui.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.SubcomposeAsyncImage
import com.bashkir.bookly.ui.theme.ImageShape

@Composable
fun AsyncBookImage(
    image: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) = SubcomposeAsyncImage(
    model = image,
    null,
    modifier.clip(ImageShape),
    loading = { CircularProgressIndicator() },
    contentScale = contentScale
)