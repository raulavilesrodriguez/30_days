package com.example.thirtydays.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recipe(
    @StringRes val nameRecipe: Int,
    @StringRes val descriptionRecipe: Int,
    @DrawableRes val imageRecipe: Int
)
