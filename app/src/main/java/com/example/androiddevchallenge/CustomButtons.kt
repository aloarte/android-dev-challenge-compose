package com.example.androiddevchallenge

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Shapes
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MySootheTheme

@Composable

fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    border: BorderStroke? = null,
    contentColor: Color,
    backgroundColor: Color,
    content: @Composable RowScope.() -> Unit
) {
    MySootheSurface(
        shape = MaterialTheme.shapes.medium,
        contentColor = contentColor,
        color = backgroundColor,
        border = border,
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = null
            )
    ) {
        ProvideTextStyle(
            value = MaterialTheme.typography.button,
        ) {
            Row(
                Modifier
                    .defaultMinSize(
                        minWidth = ButtonDefaults.MinWidth,
                        minHeight = ButtonDefaults.MinHeight
                    )
                    .indication(interactionSource, rememberRipple())
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}


@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    MySootheTheme() {
        CustomButton(
            backgroundColor = MaterialTheme.colors.primary.copy(),
            contentColor = MaterialTheme.colors.onSecondary.copy(),
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            onClick = onClick,
            content = content
        )
    }
}

@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    CustomButton(
        contentColor = MaterialTheme.colors.onPrimary,
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        onClick = onClick,
        content = content.apply {  }
    )
}


