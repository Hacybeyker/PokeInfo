package com.hacybeyker.pokeinfo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.hacybeyker.pokeinfo.R
import com.hacybeyker.pokeinfo.ui.home.Pokemon

@Composable
fun PokemonItem(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .testTag("CardPokemonItem"),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (image, number, name, type) = createRefs()

            Image(
                modifier = Modifier
                    .background(Color.Red)
                    .width(120.dp)
                    .fillMaxHeight()
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                painter = painterResource(id = R.drawable.pokemon_mankey),
                contentDescription = "pokemonImange"
            )

            Text(
                modifier = Modifier
                    .background(Color.Yellow)
                    .constrainAs(number) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(image.end)
                        width = Dimension.fillToConstraints
                    },
                maxLines = 1,
                textAlign = TextAlign.End,
                // text = "${pokemon.id}"
                text = "222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222"
            )
        }
    }
}

@Preview
@Composable
fun PokemonItemPreview() {
    val pokemon: Pokemon = Pokemon(1, "Pikachu", "Electrico")
    PokemonItem(modifier = Modifier, pokemon = pokemon)
}
