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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
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
    var textState by remember { mutableStateOf(TextFieldValue()) }
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
            Spacer(modifier = Modifier.height(56.dp))
            UserInputText(
                textFieldValue = textState,
                onTextChanged = { textState = it }
            )
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

@ExperimentalFoundationApi
@Composable
private fun UserInputText(
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChanged: (TextFieldValue) -> Unit,
    textFieldValue: TextFieldValue
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Surface {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f)
                    .align(Alignment.Bottom)
            ) {
                BasicTextField(
                    value = textFieldValue,
                    onValueChange = { onTextChanged(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                        .align(Alignment.CenterStart),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType,
                        imeAction = ImeAction.Send
                    ),
                    maxLines = 1,
                    cursorBrush = SolidColor(LocalContentColor.current),
                    textStyle = LocalTextStyle.current.copy(color = LocalContentColor.current)
                )
            }
        }
    }
}
