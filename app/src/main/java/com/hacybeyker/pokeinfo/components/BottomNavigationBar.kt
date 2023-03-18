package com.hacybeyker.pokeinfo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.hacybeyker.pokeinfo.ui.navigation.Routes

@Composable
fun MyBottomNavigation(
    navController: NavHostController,
    items: List<Routes>
) {
    var selectedItem by remember { mutableStateOf(0) }
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                icon = {
                    Image(
                        painter = painterResource(id = item.icon),
                        modifier = Modifier.size(24.dp),
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                alwaysShowLabel = true
            )
        }
    }
}
