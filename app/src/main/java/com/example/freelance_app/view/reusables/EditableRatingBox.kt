package com.example.freelance_app.view.reusables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.freelance_app.R

@Composable
fun EditableRatingBox(
    modifier: Modifier = Modifier, iconSize: Int = 30, onChange: (rating: Int) ->
    Unit
) {
    var rating by remember { mutableStateOf(5) }

    Row(
        modifier = modifier
    ) {
        for (i in 1..5) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_star_24),
                contentDescription = null,
                tint = if (i <= rating) Color.Yellow else Color.LightGray,
                modifier = Modifier
                    .size(iconSize.dp)
                    .clickable {
                        rating = i
                        onChange(i)
                    },
            )
        }
    }
}