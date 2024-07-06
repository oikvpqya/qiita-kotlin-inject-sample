package me.oikvpqya.playground.ui

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface AppRouteFactory {

    fun NavGraphBuilder.create(
        navController: NavController,
        modifier: Modifier = Modifier,
    )

    fun create(
        navController: NavController,
        navGraphBuilder: NavGraphBuilder,
        modifier: Modifier,
    ) {
        navGraphBuilder.create(
            navController, modifier
        )
    }
}

fun NavGraphBuilder.create(
    factory: AppRouteFactory,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    factory.create(navController, this, modifier)
}

fun NavGraphBuilder.create(
    factories: Set<AppRouteFactory>,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    factories.forEach { create(it, navController, modifier) }
}
