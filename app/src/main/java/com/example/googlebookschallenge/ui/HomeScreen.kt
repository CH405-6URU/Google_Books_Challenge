package com.example.googlebookschallenge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlebookschallenge.GoogleBook
import com.example.googlebookschallenge.ui.theme.GoogleBooksChallengeTheme

val mockImageSource = listOf<String>(
    "mock image source 1",
    "mock image source 2",
    "mock image source 3",
    "mock image source 4",
    "mock image source 5"
)
val mockData = List<GoogleBook>(5) { GoogleBook(id = "${it+1}", mockImageSource[it]) }

@Composable
fun BookScreen(books: List<GoogleBook>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(items = books, key = { book -> book.id }) { book ->
            BookCard(book)
        }
    }
}

@Composable
fun BookCard(book: GoogleBook) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = 8.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // to be replaced with async image later
            Text(text = book.id)
            Text(text = book.imgSrc)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoogleBooksChallengeTheme {
        BookScreen(books = mockData)
    }
}