package com.example.thirtydays

import android.content.res.Configuration
import android.widget.ImageButton
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.thirtydays.model.RecipesRepository
import com.example.thirtydays.ui.theme.ThirtyDaysTheme


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RecipeList(
    recipes: List<Recipe>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    LazyColumn(contentPadding = contentPadding){
        itemsIndexed(recipes){index, recipe ->
            RecipeItem(
                index = index+1,
                recipe = recipe,
                modifier = modifier
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                        vertical = dimensionResource(id = R.dimen.padding_small)
                    )
            )
        }
    }
}

@Composable
fun RecipeItem(
    index: Int,
    recipe: Recipe,
    modifier: Modifier = Modifier
){
    var expanded by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation_small)),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = stringResource(id = R.string.title_day, index),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Text(
                text = stringResource(id = recipe.nameRecipe),
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            RecipeImageButton(
                onClick = { expanded = !expanded },
                imageRecipe = recipe.imageRecipe,
                descriptionRecipe = recipe.descriptionRecipe,
                modifier = Modifier
            )
            if (expanded) {
                DescriptionLarge(descriptionRecipe = recipe.descriptionRecipe)
            }
        }
    }
}

@Composable
private fun RecipeImageButton(
    onClick: () -> Unit,
    imageRecipe: Int,
    descriptionRecipe: Int,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = imageRecipe),
            contentDescription = stringResource(id = descriptionRecipe),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}


@Composable
private fun DescriptionLarge(
    @StringRes descriptionRecipe: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(id = descriptionRecipe),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small))
    )

}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RecipePreview(){
    val recipe = Recipe(
        R.string.recipe1,
        R.string.description1,
        R.drawable.spaghetti1
    )
    ThirtyDaysTheme{
        RecipeItem(index = 1, recipe = recipe)
    }
}

@Preview("Recipe List")
@Composable
fun RecipesPreview(){
    ThirtyDaysTheme(){
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            RecipeList(RecipesRepository.recipes)
        }
    }
}


