/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MySootheTheme
@ExperimentalFoundationApi
class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            MySootheTheme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        bottomBar = {
                            val items = listOf(
                                Screen.HomeScreen,
                                Screen.ProfileScreen,
                            )
                            BottomNavigation(
                                elevation = 10.dp,
                                backgroundColor = MaterialTheme.colors.background
                            ) {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentRoute =
                                    navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                                items.forEach { screen ->
                                    BottomNavigationItem(
                                        selectedContentColor = MaterialTheme.colors.onBackground,
                                        unselectedContentColor = Color.Gray,
                                        label = { Text(text = stringResource(id = screen.resourceId)) },
                                        icon = {
                                            Icon(
                                                painter = painterResource(id = screen.iconId),
                                                contentDescription = ""
                                            )
                                        },
                                        selected = currentRoute == screen.route,
                                        onClick = {
                                            navController.popBackStack(
                                                navController.graph.startDestination, false
                                            )
                                            if (currentRoute != screen.route) {
                                                navController.navigate(screen.route)
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    ) {
                        HomeScreenController(navController = navController)
                    }
                }
            }
        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun HomeScreenController(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                Home()
            }
            composable("profile") {
            }
        }
    }
}
