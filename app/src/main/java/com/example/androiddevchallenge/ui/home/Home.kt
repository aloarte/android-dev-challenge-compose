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

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.typography
import java.util.Locale

@ExperimentalFoundationApi
@Composable
fun Home() {

    val collectionsList = listOf(
        CollectionViewState("Stress and anxiety", R.mipmap.stress_anxiety),
        CollectionViewState("Overwhelmed", R.mipmap.overwhelmed),
        CollectionViewState("Self-massage", R.mipmap.self_massage),
        CollectionViewState("Nightly wind down", R.mipmap.night_wind_down)
    )
    val alignYourBodyList = listOf(
        AlignViewState("Inversions", R.mipmap.inversions),
        AlignViewState("Quick Yoga", R.mipmap.quick_yoga),
        AlignViewState("Stretching", R.mipmap.stretching),
        AlignViewState("Tabata", R.mipmap.tabata),
        AlignViewState("HIIT", R.mipmap.hiit),
        AlignViewState("Pre-natal yoga", R.mipmap.pre_natal_yoga)
    )
    val alignYourMindList = listOf(
        AlignViewState("Meditate", R.mipmap.meditate),
        AlignViewState("With kids", R.mipmap.with_kids),
        AlignViewState("Aromatherapy", R.mipmap.aromatherapy),
        AlignViewState("On the go", R.mipmap.on_the_go),
        AlignViewState("With pets", R.mipmap.with_pets),
        AlignViewState("High stress", R.mipmap.high_stress)
    )

    Surface(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = ((MaterialTheme.colors.background).copy(alpha = 1.0F))

    ) {

        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(36.dp))
            StyledTextField()
            Spacer(modifier = Modifier.height(40.dp))
            RowTitleTextView(stringResource(id = R.string.row_collections_title))
            CollectionsList(Modifier, collectionsList)
            Spacer(modifier = Modifier.height(40.dp))
            RowTitleTextView(stringResource(id = R.string.row_body_title))
            AlignList(Modifier, alignYourBodyList)
            Spacer(modifier = Modifier.height(40.dp))
            RowTitleTextView(stringResource(id = R.string.row_mind_title))
            AlignList(Modifier, alignYourMindList)
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun RowTitleTextView(title: String) {
    Text(
        text = title.toUpperCase(Locale.getDefault()),
        style = typography.h2,
        color = MaterialTheme.colors.onBackground
    )
}

@Composable
fun StyledTextField() {
    var value by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.End
    ) {
        TextField(
            value = value,
            onValueChange = { value = it },
            placeholder = {
                Text(
                    stringResource(R.string.search_textfield),
                    style = typography.body1
                )
            },
            maxLines = 1,
            textStyle = typography.body1,
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.onSecondary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Gray
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = ""
                )
            },

        )
    }
}
