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
    private val imageLoader: ImageLoader,
    private val routeFactories: Set<AppRouteFactory>,
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
                    routeFactories = routeFactories,
                    modifier = modifier,
                )
            }
        }
    }
}

@Composable
fun App(
    routeFactories: Set<AppRouteFactory>,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier,
    ) {
        create(
            factories = routeFactories,
            navController = navController,
        )
    }
}
