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
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun Welcome() {

    Surface(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = ((MaterialTheme.colors.background).copy(alpha = 1.0F))

    ) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(if (isSystemInDarkTheme()) R.drawable.dark_welcome else R.drawable.light_welcome),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(PaddingValues(16.dp, 16.dp, 16.dp, 16.dp)),
            verticalArrangement = Arrangement.Center

        ) {
            WelcomeContent()
        }
    }
}

@Composable
fun WelcomeContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(if (isSystemInDarkTheme()) R.drawable.dark_logo else R.drawable.light_logo),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton(
            onClick = {
            }
        ) {
            Text(
                stringResource(id = R.string.btn_sign_up).toUpperCase(Locale.current),
                modifier = Modifier.padding(horizontal = 16.dp),
                style = typography.button

            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        SecondaryButton(
            onClick = {
            }
        ) {
            Text(
                stringResource(id = R.string.btn_log_in).toUpperCase(Locale.current),
                modifier = Modifier.padding(horizontal = 16.dp),
                style = typography.button
            )
        }
    }
}
