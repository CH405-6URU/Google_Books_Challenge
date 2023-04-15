package com.example.googlebookschallenge.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.googlebookschallenge.data.BookUiState
import com.example.googlebookschallenge.data.Item
import com.example.googlebookschallenge.ui.theme.GoogleBooksChallengeTheme


// TODO figure out how to parse the returned response. It starts with { instead of [ which fucks up everything...


@Composable
fun HomeScreen(bookUiState: BookUiState) {
    when (bookUiState) {
        is BookUiState.Success -> BookScreen(books = bookUiState.books)
        is BookUiState.Error -> ErrorScreen()
        is BookUiState.Loading -> LoadingScreen()
        else -> {  ErrorScreen() }
    }
}


val mockImageSource = listOf(
    "mock image source 1",
    "mock image source 2",
    "mock image source 3",
    "mock image source 4",
    "mock image source 5"
)
/*val mockData2 = List(3){
    Response(
        kind = "${it + 1}",
        totalItems = 69,
        items = mockData
    )
}*/
/*val mockData = List(5) {
    Item()
}*/

@Composable
fun BookScreen(books: MutableList<Item>) {
    Log.d("BookScreen", books.toString())
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(items = books, key = { books -> books.id }) { book ->
            BookCard(book)
        }
    }
}

@Composable
fun BookCard(book: Item) {
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
            Text(text = book.volumeInfo.title)
            // Text(text = book.id)
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data((book.volumeInfo.imageLinks.large)?.replace("http","https"))
                    .crossfade(true).build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

// Loading Screen
@Composable
fun LoadingScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Loading")
    }
}

// Error screen
@Composable
fun ErrorScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Error")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoogleBooksChallengeTheme {
      //  BookScreen(mockData)
    }
}