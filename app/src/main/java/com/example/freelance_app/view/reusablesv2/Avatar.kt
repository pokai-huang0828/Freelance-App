package com.example.freelance_app.view.reusablesv2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.freelance_app.utils.CustomColors

@Composable
fun Avatar(avatarImg: Int, imageSize: Dp) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .offset(y = (15).dp)
    ) {
        Box(
            modifier = Modifier
                .size(imageSize + 20.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            CustomColors.primary,
                            Color.Transparent
                        )
                    )
                )
                .padding(bottom = 4.dp),
        ) {
            Image(
                rememberImagePainter(
                    data = avatarImg,
                    builder = {
                        transformations(
                            CircleCropTransformation()
                        )
                    },
                ),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(imageSize)
            )
        }
    }
}