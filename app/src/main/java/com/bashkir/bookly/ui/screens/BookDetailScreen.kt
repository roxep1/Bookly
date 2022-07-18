package com.bashkir.bookly.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.bashkir.bookly.data.Async
import com.bashkir.bookly.data.BooksViewModel
import com.bashkir.bookly.data.models.Book
import com.bashkir.bookly.data.models.Image
import com.bashkir.bookly.ui.components.*
import com.bashkir.bookly.ui.theme.*

@Composable
fun BookDetailScreen(
    navController: NavController,
    viewModel: BooksViewModel,
    bookId: Int
) = ConstraintLayout(Modifier.mainViewModifier()) {
    val (topIconsBar, bookInfo, similarBooks) = createRefs()

    val books by viewModel.uiState.best.collectAsState(initial = Async.Uninitialized)
    val similarImages by viewModel.uiState.similar.collectAsState(initial = Async.Uninitialized)

    TopIconsBar(leadingIcon = {
        IconButton(onClick = navController::popBackStack) {
            Icon(Icons.Default.Close, null)
        }
    }, trailingIcon = { Icon(Icons.Default.ShoppingCart, null) },
        modifier = Modifier.constrainAs(topIconsBar) {
            top.linkTo(parent.top)
        }
    )
    Column(
        Modifier
            .fillMaxWidth()
            .constrainAs(bookInfo) {
                top.linkTo(topIconsBar.bottom)
            }, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncView(async = books) {
            it.find { book -> book.id == bookId }!!.let { book ->
                BookInfo(book)
                Buttons(book.price)
            }
        }
    }
    Column(
        Modifier
            .fillMaxWidth()
            .constrainAs(similarBooks) {
                bottom.linkTo(parent.bottom, normalPadding)
            }) {
        AsyncView(async = similarImages) { images ->
            SimilarBooks(images = images)
        }
    }
}

@Composable
private fun BookInfo(book: Book) {
    AsyncBookImage(
        image = book.image,
        Modifier
            .padding(bottom = bigPadding)
            .width(carouselCardWidth)
            .height(carouselCardHeight)
    )
    Text(book.title, style = detailTitleText)
    Text(book.author, style = detailAuthorText)
    Spacer(modifier = Modifier.height(normalPadding))
    RateView(rate = book.rate)
}

@Composable
private fun Buttons(price: Float) = Row(
    Modifier
        .padding(vertical = bigPadding)
        .fillMaxWidth()
) {
    Button(
        {},
        Modifier.weight(1f),
        shape = RoundedCornerShape(topStart = cornerRadius, bottomStart = cornerRadius),
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        PriceView(price, Color.Black)
    }
    Button(
        {},
        Modifier.weight(1f),
        shape = RoundedCornerShape(topEnd = cornerRadius, bottomEnd = cornerRadius),
        colors = ButtonDefaults.buttonColors(FreeButtonColor)
    ) {
        Text("Free preview", style = freeButtonText)
    }
}

@Composable
private fun SimilarBooks(images: List<Image>) {
    Text("You can also like", style = similarBooksText)
    LazyRow(
        Modifier
            .padding(vertical = normalPadding)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(normalPadding)
    ) {
        items(images) { image ->
            AsyncBookImage(image = image.image, Modifier.height(smallBookImageHeight))
        }
    }
}