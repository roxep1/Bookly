package com.bashkir.bookly.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.bashkir.bookly.R

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

val normalText = TextStyle(
    fontSize = normalTextSize,
    color = Color.White,
    fontFamily = Montserrat
)

val bestBooksTitle = TextStyle(
    fontSize = titleTextSize,
    color = Color.White
)

val authorText = TextStyle(
    fontSize = verySmallTextSize,
    color = Color.White.copy(alpha = 0.7f),
    fontFamily = Montserrat
)

val rateAmountText = TextStyle(
    fontSize = verySmallTextSize,
    color = Color.White.copy(alpha = 0.5f),
    fontFamily = Montserrat
)

val similarBooksText = TextStyle(
    fontSize = verySmallTextSize,
    color = Color.White,
    fontFamily = Montserrat
)

val priceText = TextStyle(
    fontSize = titleTextSize,
    color = Color.White,
    fontFamily = Montserrat
)

val rateText = TextStyle(
    fontSize = smallTextSize,
    fontWeight = FontWeight.Bold,
    color = Color.White,
    fontFamily = Montserrat
)

val detailTitleText = TextStyle(
    fontSize = headTextSize,
    color = Color.White,
    textAlign = TextAlign.Center
)

val detailAuthorText = TextStyle(
    fontSize = normalTextSize,
    color = Color.White.copy(alpha = 0.7f),
    fontFamily = Montserrat
)

val freeButtonText = TextStyle(
    fontSize = titleTextSize,
    fontWeight = FontWeight.Bold,
    color = Color.White
)