package com.example.thirtydays

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydays.model.Recipe
import com.example.thirtydays.ui.theme.ThirtyDaysTheme

@Composable
fun RecipeItem(
    index: Int,
    recipe: Recipe,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation_small)),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = stringResource(id = R.string.title_day, index.toString()),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Text(
                text = stringResource(id = recipe.descriptionRecipe),
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Box(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size))
                    .clip(MaterialTheme.shapes.small)

            ){
                Image(
                    painter = painterResource(id = recipe.imageRecipe),
                    contentDescription = stringResource(id = recipe.descriptionRecipe),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillHeight
                )
            }
            DescriptionLarge(descriptionRecipe = recipe.descriptionRecipe)
        }
    }
}

@Composable
fun DescriptionLarge(
    @StringRes descriptionRecipe: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(id = descriptionRecipe),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small))
    )

}

