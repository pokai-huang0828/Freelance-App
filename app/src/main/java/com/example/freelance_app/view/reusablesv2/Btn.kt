package com.example.freelance_app.view.reusablesv2

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freelance_app.utils.CustomColors

@Composable
fun Btn(text: String, padding: Int = 37) {
    TextButton(
        onClick = { },
        Modifier
            .border(
                4.dp,
                color = CustomColors.primary,
                shape = RoundedCornerShape(60)
            )
            .clip(RoundedCornerShape(15))
            .background(color = CustomColors.primary)
    ) {
        Text(
            text = text,
            Modifier
                .padding(horizontal = padding.dp, vertical = 2.dp),
            color = Color.White,
            fontSize = 17.sp,
            fontStyle = FontStyle.Italic
        )
    }
}