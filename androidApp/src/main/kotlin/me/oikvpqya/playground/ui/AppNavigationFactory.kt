package me.oikvpqya.playground.ui

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import me.tatarka.inject.annotations.Inject

interface AppNavigationFactory {

    fun create(
        navController: NavController,
        navGraphBuilder: NavGraphBuilder,
        modifier: Modifier = Modifier,
    )
}

@Inject
class AppNavigationFactoryImpl(
    private val homeRoute: HomeRoute,
    private val imageRoute: ImageRoute,
) : AppNavigationFactory {

    override fun create(
        navController: NavController,
        navGraphBuilder: NavGraphBuilder,
        modifier: Modifier,
    ) {
        with(navGraphBuilder) {
            composable<Home> { _ ->
                homeRoute(navController, modifier)
            }
            composable<Image> { backStackEntry ->
                val image = backStackEntry.toRoute<Image>()
                imageRoute(image.path, navController, modifier)
            }
        }
    }
}
