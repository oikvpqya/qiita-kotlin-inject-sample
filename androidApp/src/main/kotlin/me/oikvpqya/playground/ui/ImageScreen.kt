package me.oikvpqya.playground.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import kotlinx.serialization.Serializable
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject

@Serializable
data class Image(
    val path: String,
)

typealias ImageRoute = @Composable (
    path: String,
    navController: NavController,
    modifier: Modifier,
) -> Unit

@Composable
@Inject
fun ImageRoute(
    @Assisted path: String,
    @Assisted navController: NavController,
    @Assisted modifier: Modifier = Modifier,
) {
    ImageScreen(
        path = path,
        onNavigateToHome = {navController.navigate(Home)},
        modifier = modifier,
    )
}

@Composable
fun ImageScreen(
    path: String,
    onNavigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Button(onClick = onNavigateToHome) {
            Text(text = "Go to Home")
        }
        Text(text = "path: $path")
        AsyncImage(
            model = path,
            contentDescription = null,
        )
    }
}
