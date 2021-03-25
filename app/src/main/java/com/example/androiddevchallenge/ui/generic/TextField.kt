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
package com.example.androiddevchallenge.ui.generic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun StyledTextField(placeholder: Int, leadingIcon: Int, unfocusedIndicatorColor: Color) {
    var value by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.End
    ) {
        TextField(
            value = value,
            onValueChange = { value = it },
            placeholder = {
                Text(
                    stringResource(placeholder),
                    style = typography.body1,
                    color = MaterialTheme.colors.primary
                )
            },
            maxLines = 1,
            textStyle = typography.body1,
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.onSurface,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = unfocusedIndicatorColor
            ),
            leadingIcon = {
                if (leadingIcon != -1) {
                    Icon(
                        painter = painterResource(id = leadingIcon),
                        contentDescription = "",
                        tint = MaterialTheme.colors.primary
                    )
                }
            },

        )
    }
}

@Composable
fun PasswordStyledTextField(placeholder: Int, leadingIcon: Int, unfocusedIndicatorColor: Color) {
    var value by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.End,
    ) {
        TextField(
            value = value,
            onValueChange = { value = it },
            placeholder = {
                Text(
                    stringResource(placeholder),
                    style = typography.body1,
                    color = MaterialTheme.colors.primary
                )
            },
            maxLines = 1,
            textStyle = typography.body1,
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.onSurface,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = unfocusedIndicatorColor
            ),
            leadingIcon = {
                if (leadingIcon != -1) {
                    Icon(
                        painter = painterResource(id = leadingIcon),
                        contentDescription = "",
                        tint = MaterialTheme.colors.primary
                    )
                }
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )
    }
}
