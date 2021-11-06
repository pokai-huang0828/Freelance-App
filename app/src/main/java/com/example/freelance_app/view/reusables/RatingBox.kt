package com.example.freelance_app.view.reusables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.freelance_app.R

@Composable
fun RatingBox(rating: Int, iconSize: Int = 30) {
    if (rating > -1 && rating <= 5) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            for (i in 0..rating - 1) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_star_24),
                    contentDescription = null,
                    tint = Color.Yellow,
                    modifier = Modifier.size(iconSize.dp)
                )
            }
        }
    }
}