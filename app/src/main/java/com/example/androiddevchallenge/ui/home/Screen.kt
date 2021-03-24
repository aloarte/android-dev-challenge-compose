package com.example.androiddevchallenge.ui.home

import androidx.annotation.StringRes
import com.example.androiddevchallenge.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val iconId: Int) {
    object HomeScreen : Screen("home", R.string.bottom_nav_home, R.drawable.ic_spa)
    object ProfileScreen : Screen("profile", R.string.bottom_nav_profile, R.drawable.ic_account_circle)
}
