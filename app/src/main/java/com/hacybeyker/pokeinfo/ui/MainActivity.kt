package com.hacybeyker.pokeinfo.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.hacybeyker.pokeinfo.components.MyBottomNavigation
import com.hacybeyker.pokeinfo.ui.navigation.RootNavigation
import com.hacybeyker.pokeinfo.ui.navigation.Routes
import com.hacybeyker.pokeinfo.ui.theme.AndroidtemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidtemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navigationItems = listOf(Routes.HomeRoute, Routes.FavoriteRoute)

    Scaffold(
        modifier = Modifier.fillMaxSize().border(width = 4.dp, color = Color.Red),
        bottomBar = { MyBottomNavigation(navController = navController, items = navigationItems) }
    ) {
        RootNavigation(navController = navController)
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
