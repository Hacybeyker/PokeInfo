package com.hacybeyker.pokeinfo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.hacybeyker.pokeinfo.domain.entity.PokemonEntity

@Composable
fun PokemonItem(modifier: Modifier = Modifier, pokemon: PokemonEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(6.dp)
            .testTag("CardPokemonItem"),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (image, number, name, type) = createRefs()

            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.image)
                    .size(Size.ORIGINAL)
                    .build()
            )
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
                // painter = painterResource(id = R.drawable.pokemon_mankey),
                painter = painter,
                contentDescription = "pokemonImange"
            )

            Text(
                modifier = Modifier
                    .background(Color.Yellow)
                    .constrainAs(number) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end, margin = 4.dp)
                        start.linkTo(image.end, margin = 4.dp)
                        bottom.linkTo(name.top)
                        width = Dimension.fillToConstraints
                    },
                maxLines = 1,
                textAlign = TextAlign.End,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                text = "#${pokemon.id}"
            )

            Text(
                modifier = Modifier
                    .background(Color.Magenta)
                    .constrainAs(name) {
                        start.linkTo(image.end, margin = 4.dp)
                        top.linkTo(number.bottom)
                        end.linkTo(parent.end, margin = 4.dp)
                        bottom.linkTo(type.top)
                        width = Dimension.fillToConstraints
                    },
                maxLines = 1,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Start,
                text = pokemon.name
            )

            Text(
                modifier = Modifier
                    .background(Color.Green)
                    .constrainAs(type) {
                        start.linkTo(image.end, margin = 4.dp)
                        top.linkTo(name.bottom)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end, margin = 4.dp)
                        width = Dimension.fillToConstraints
                    },
                maxLines = 1,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Start,
                text = pokemon.name
            )
        }
    }
}

@Preview
@Composable
fun PokemonItemPreview() {
    val pokemon: PokemonEntity = PokemonEntity(1, "Pikachu", "")
    PokemonItem(modifier = Modifier, pokemon = pokemon)
}
