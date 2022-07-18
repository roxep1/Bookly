package com.bashkir.bookly.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bashkir.bookly.data.BooksViewModel
import com.bashkir.bookly.ui.screens.BookDetailScreen
import com.bashkir.bookly.ui.screens.BooksScreen

enum class Screen(val destination: String) {
    Books("books"),
    BookDetail("book_detail");

    companion object {
        const val MAIN_ROUTE = "main"
    }
}

@Composable
fun MainNavHost(navController: NavHostController) =
    NavHost(
        navController = navController,
        startDestination = Screen.Books.destination,
        route = Screen.MAIN_ROUTE
    ) {
        composable(Screen.Books.destination) {
            BooksScreen(navController = navController, viewModel = navController.getViewModel(it))
        }

        composable("${Screen.BookDetail.destination}/{bookId}") {
            BookDetailScreen(
                navController = navController,
                viewModel = navController.getViewModel(it),
                it.arguments?.getString("bookId")!!.toInt()
            )
        }
    }

@Composable
private fun NavController.getViewModel(backStackEntry: NavBackStackEntry): BooksViewModel =
    hiltViewModel(remember(backStackEntry) { getBackStackEntry(Screen.MAIN_ROUTE) })