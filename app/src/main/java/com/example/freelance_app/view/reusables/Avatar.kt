package com.example.freelance_app.view.reusables

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.freelance_app.R

@Composable
fun Avatar(
   imageUrl: String
) {
    Image(
        painter = rememberImagePainter(data = imageUrl),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
    )
}