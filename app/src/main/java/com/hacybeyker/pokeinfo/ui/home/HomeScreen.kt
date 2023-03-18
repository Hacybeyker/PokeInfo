package com.hacybeyker.pokeinfo.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hacybeyker.pokeinfo.components.PokemonItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val search by homeViewModel.search.observeAsState("")
    val listPokemon by homeViewModel.listPokemon.observeAsState(arrayListOf())

    Row(
        modifier = Modifier
            .fillMaxSize()
            .border(width = 6.dp, color = Color.Black)
    ) {
        ConstraintLayout(
            modifier = modifier.fillMaxSize()
        ) {
            val (searchComponent, listComponent) = createRefs()

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
                    .constrainAs(searchComponent) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    },
                shape = RoundedCornerShape(15.dp),
                placeholder = { Text(text = "Search", color = Color.Gray) },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "searchIcon")
                },
                trailingIcon = {
                    if (search.isNotEmpty()) {
                        IconButton(onClick = { homeViewModel.clearSearch() }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "searchIcon"
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                maxLines = 1,
                value = search,
                onValueChange = { homeViewModel.updateSearch(it) }
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp)
                    .testTag("list_pokemon")
                    .constrainAs(listComponent) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(searchComponent.bottom)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                    }
            ) {
                items(items = listPokemon) { pokemon ->
                    PokemonItem(pokemon = pokemon)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}
