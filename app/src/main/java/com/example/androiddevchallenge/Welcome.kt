package com.example.androiddevchallenge

import android.content.res.Resources
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MySootheTheme
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

            }) {
            Text(
                stringResource(id = R.string.btn_sign_up).toUpperCase(),
                modifier = Modifier.padding(horizontal = 16.dp),
                style = typography.button

            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        SecondaryButton(
            onClick = {

            }) {
            Text(
                stringResource(id = R.string.btn_log_in).toUpperCase(),
                modifier = Modifier.padding(horizontal = 16.dp),
                style = typography.button
            )
        }
    }
}

