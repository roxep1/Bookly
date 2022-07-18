package com.bashkir.bookly.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.bashkir.bookly.R
import com.bashkir.bookly.data.Async
import com.bashkir.bookly.data.BooksViewModel
import com.bashkir.bookly.data.models.Book
import com.bashkir.bookly.data.models.Image
import com.bashkir.bookly.ui.Screen
import com.bashkir.bookly.ui.components.*
import com.bashkir.bookly.ui.theme.*

@Composable
fun BooksScreen(navController: NavController, viewModel: BooksViewModel) =
    Column(Modifier.mainViewModifier()) {
        val carouselImages by viewModel.uiState.carousel.collectAsState(Async.Uninitialized)
        val bestBooks by viewModel.uiState.best.collectAsState(Async.Uninitialized)

        TopIconsBar(
            leadingIcon = {
                Image(
                    painterResource(R.drawable.logo),
                    null,
                    Modifier.height(logoHeight),
                    contentScale = ContentScale.Crop
                )
            },
            trailingIcon = { Icon(Icons.Default.Search, null) }
        )

        AsyncView(carouselImages) { images ->
            CarouselImagesView(images = images)
        }
        Spacer(modifier = Modifier.height(bigPadding))
        Text(
            "Best Seller",
            style = normalText,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = normalPadding)
        )

        AsyncView(bestBooks) { books ->
            BestBooksView(books) {
                navController.navigate("${Screen.BookDetail.destination}/${it.id}")
            }
        }
    }

@Composable
private fun CarouselImagesView(images: List<Image>) =
    LazyRow(
        Modifier.fillMaxWidth(),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(normalPadding)
    ) {
        itemsIndexed(images) { index, image ->
            AsyncBookImage(
                image.image,
                Modifier.height(if (index != 0) carouselCardHeight else firstCarouselCardHeight)
            )
        }
    }

@Composable
private fun BestBooksView(books: List<Book>, onClick: (Book) -> Unit) = LazyColumn {
    items(books) { book ->
        BookCard(book) { onClick(book) }
    }
}

@Composable
private fun BookCard(book: Book, onClick: () -> Unit) = Row(
    Modifier
        .fillMaxWidth()
        .padding(vertical = normalPadding)
        .clickable(onClick = onClick),
    verticalAlignment = CenterVertically
) {
    AsyncBookImage(book.image, Modifier.width(smallBookImageWidth))
    Spacer(modifier = Modifier.width(bigPadding))
    Column {
        Text(book.title, style = bestBooksTitle)
        Text(book.author, style = authorText)
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = CenterVertically
        ) {
            PriceView(price = book.price)
            RateView(rate = book.rate)
        }
    }
}