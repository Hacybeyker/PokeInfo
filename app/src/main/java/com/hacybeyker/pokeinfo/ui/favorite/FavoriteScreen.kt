package com.hacybeyker.pokeinfo.ui.favorite

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController

@Composable
fun FavoriteScreen(navController: NavHostController) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (demo) = createRefs()
        Text(
            text = "Favorite",
            modifier = Modifier
                .height(150.dp)
                .border(width = 2.dp, color = Color.Red)
                .constrainAs(demo) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}
