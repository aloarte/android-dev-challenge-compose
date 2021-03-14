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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography

data class CollectionViewState(
    val text: String,
    val imageDrawableId: Int
)

data class AlignViewState(
    val text: String,
    val imageDrawableId: Int
)

@Composable
fun MyComposeList(
    modifier: Modifier = Modifier,
    itemViewStates: List<AlignViewState>
) {
    LazyRow(modifier = modifier) {
        items(itemViewStates) { data ->
            AlignListItem(data)
            if (data != itemViewStates.last()) Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun AlignListItem(itemState: AlignViewState) {
    Column(
        Modifier.padding(top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            painter = painterResource(itemState.imageDrawableId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        ItemTextView(title = itemState.text)
    }
}

@Composable
private fun ItemTextView(title: String) {
    Text(
        text = title,
        style = typography.body1,
        color = MaterialTheme.colors.primary
    )
}
