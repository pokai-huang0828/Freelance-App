package com.example.freelance_app.view.reusablesv2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.freelance_app.utils.CustomColors

@Composable
fun CustomField(
    text: String,
    modifier: Modifier = Modifier,
    label: String = "Info",
    placeholder: String = "Company Description",
    switch: Boolean = true,
    bgColor: Color = CustomColors.primaryLight,
    textColor: Color = CustomColors.primaryLight,
    transfer: (String) -> Unit
) {
    var description by remember { mutableStateOf(text) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
                transfer(it)
            },
            label = { Text(label) },
            colors = TextFieldDefaults
                .outlinedTextFieldColors(
                    focusedLabelColor = CustomColors.primary,
                    cursorColor = CustomColors.primary,
                    textColor = CustomColors.primary,
                    unfocusedBorderColor = CustomColors.primary10,
                    backgroundColor = bgColor,
                    unfocusedLabelColor = CustomColors.primary10,
                    disabledLabelColor = CustomColors.primary10,
                    disabledBorderColor = CustomColors.primary10,
                    disabledTextColor = textColor,
                ),
            placeholder = {
                Text(
                    text = placeholder,
                    color = CustomColors.primary20
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .width(15.dp),
            enabled = switch
        )
    }
}