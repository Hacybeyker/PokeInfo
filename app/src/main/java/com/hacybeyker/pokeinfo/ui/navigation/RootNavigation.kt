package com.hacybeyker.pokeinfo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hacybeyker.pokeinfo.R
import com.hacybeyker.pokeinfo.ui.favorite.FavoriteScreen
import com.hacybeyker.pokeinfo.ui.home.HomeScreen

@Composable
fun RootNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeRoute.route
    ) {
        composable(route = Routes.HomeRoute.route) { HomeScreen(navController) }
        composable(route = Routes.FavoriteRoute.route) { FavoriteScreen(navController) }
    }
}

sealed class Routes(
    val route: String,
    val title: String,
    val icon: Int
) {
    object HomeRoute : Routes("home_graph", "Home", R.drawable.pokedex)
    object FavoriteRoute : Routes("favorite_graph", "Favorite", R.drawable.pokeball)
}
