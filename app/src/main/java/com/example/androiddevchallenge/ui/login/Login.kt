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
package com.example.androiddevchallenge.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.generic.PasswordStyledTextField
import com.example.androiddevchallenge.ui.generic.PrimaryButton
import com.example.androiddevchallenge.ui.generic.StyledTextField
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun Login(
    onClickParent: () -> Unit
) {

    Surface(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = ((MaterialTheme.colors.background).copy(alpha = 1.0F))

    ) {
        Image(
            contentScale = ContentScale.FillBounds,
            painter = painterResource(if (isSystemInDarkTheme()) R.drawable.dark_login else R.drawable.light_login),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center

        ) {
            LoginContent(onClickParent)
        }
    }
}

@Composable
fun LoginContent(onClickParent: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.log_in).toUpperCase(java.util.Locale.getDefault()),
            style = typography.h1,
            color = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.height(32.dp))
        StyledTextField(
            placeholder = R.string.login_email,
            leadingIcon = -1,
            unfocusedIndicatorColor = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordStyledTextField(
            placeholder = R.string.login_password,
            leadingIcon = -1,
            unfocusedIndicatorColor = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.height(10.dp))
        PrimaryButton(
            onClick = onClickParent
        ) {
            Text(
                stringResource(id = R.string.btn_log_in).toUpperCase(Locale.current),
                modifier = Modifier.padding(horizontal = 16.dp),
                style = typography.button
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(id = R.string.sign_up_reminder),
            style = typography.body1,
            color = MaterialTheme.colors.primary
        )
    }
}
