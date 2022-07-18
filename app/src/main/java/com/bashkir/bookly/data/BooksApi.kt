package com.bashkir.bookly.data

import com.bashkir.bookly.data.models.Book
import com.bashkir.bookly.data.models.Image
import retrofit2.http.GET

interface BooksApi {
    companion object{
        const val BASE_URL = "https://my-json-server.typicode.com/stellardiver/ebookdata/"
    }

    @GET("similar")
    suspend fun getSimilar(): List<Image>

    @GET("best")
    suspend fun getBest(): List<Book>

    @GET("carousel")
    suspend fun getCarousel(): List<Image>
}