package com.example.thirtydays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydays.model.Recipe
import com.example.thirtydays.ui.theme.ThirtyDaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipeApp()
                }
            }
        }
    }
}

@Composable
fun RecipeApp() {
    val recipe = Recipe(
        R.string.recipe2,
        R.string.description2,
        R.drawable.chicken2
    )
    RecipeItem(index = 1, recipe = recipe)
}

@Preview
@Composable
fun RecipeTotalPreview() {
    ThirtyDaysTheme(darkTheme = false) {
        RecipeApp()
    }
}

@Preview
@Composable
fun RecipeDarkPreview(){
    ThirtyDaysTheme(darkTheme = true) {
        RecipeApp()
    }
}