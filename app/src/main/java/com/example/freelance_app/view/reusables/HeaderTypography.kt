package com.example.freelance_app.view.reusables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freelance_app.utils.CustomColors


@Composable
fun HeaderTypography(
    text: String,
    fontWeight: FontWeight,
    fontSize: Int = 25,
    alignment: Arrangement.Horizontal,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = alignment,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = text,
                color = Color.DarkGray,
                fontSize = fontSize.sp,
                fontWeight = fontWeight,
                textAlign = TextAlign.Center,
                letterSpacing = 1.2.sp,
                modifier = Modifier
                    .offset(
                        x = 2.dp,
                        y = (fontSize + 8).dp
                    )
                    .alpha(0.75f)
            )
            Text(
                text = text,
                color = CustomColors.primary,
                fontSize = fontSize.sp,
                fontWeight = fontWeight,
                textAlign = TextAlign.Center,
                letterSpacing = 1.2.sp,
            )
        }
    }
}