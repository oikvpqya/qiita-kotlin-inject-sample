package me.oikvpqya.playground.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import me.tatarka.inject.annotations.Inject

interface AppContent {

    @Composable
    fun Content(
        modifier: Modifier,
    )
}

@Inject
class AppContentImpl(
    private val appNavigation: AppNavigation,
    private val imageLoader: ImageLoader,
) : AppContent {

    @OptIn(ExperimentalCoilApi::class)
    @Composable
    override fun Content(
        modifier: Modifier,
    ) {
        setSingletonImageLoaderFactory { imageLoader }
        MaterialTheme {
            Surface {
                App(
                    appNavigation = appNavigation,
                    modifier = modifier,
                )
            }
        }
    }
}

@Composable
fun App(
    appNavigation: AppNavigation,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier,
    ) {
        appNavigation.create(
            navGraphBuilder = this,
            navController = navController,
        )
    }
}
