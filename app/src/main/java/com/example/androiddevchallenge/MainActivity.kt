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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            MySootheTheme() {
//                MyApp()
                Welcome()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Row(
        Modifier.fillMaxHeight().fillMaxWidth()
    ){
        CustomButton(
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
            ),
            backgroundColor = MaterialTheme.colors.onSecondary,
           contentColor = MaterialTheme.colors.onSecondary,
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            onClick = {}) {
            Text(
                "Log In",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }

}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MySootheTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MySootheTheme(darkTheme = true) {
        MyApp()
    }
}
