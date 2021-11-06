package com.example.freelance_app.view.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.freelance_app.view.reusables.TopBar
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.freelance_app.R
import com.example.freelance_app.utils.CustomColors
import androidx.compose.material.icons.filled.FiberManualRecord
import com.example.freelance_app.view.reusablesv2.Avatar
import com.example.freelance_app.view.reusablesv2.Btn
import com.example.freelance_app.view.reusablesv2.CustomField
import com.example.freelance_app.view.reusablesv2.HeaderTypography


data class FakePost(
    val position: String,
    val date: String
)

@ExperimentalAnimationApi
@Composable
fun CompanyMainPageScreen(toPostScreen: () -> Unit) {

    val posts: List<FakePost> = listOf(
        FakePost(date = "Nov 5, 2021", position = "Mover"),
        FakePost(date = "Nov 5-6, 2021", position = "Dishwasher"),
        FakePost(date = "Nov 7, 2021", position = "Cleaner"),
    )
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                TopBar()
                Avatar(
                    avatarImg = R.drawable.logo_company,
                    imageSize = 100.dp
                )
                HeaderTypography(
                    text = "About Company:",
                    fontWeight = FontWeight.Bold,
                    alignment = Arrangement.Center,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .offset(y = (-15).dp)
                )
                CustomField(
                    text = "Lorem Ipsum is simply dummy text" +
                            " of the printing and typesetting industry. " +
                            "Lorem Ipsum has been the industry's standard " +
                            "dummy text ever since the 1500s, when an unknown " +
                            "printer took a galley of type and scrambled it to " +
                            "make a type specimen book. It has survived not only " +
                            "five centuries, but ",
                )
                BtnRow(text = "Save")
                ListOfPosts(posts)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { toPostScreen() },
                backgroundColor = CustomColors.primary,
                contentColor = Color.White,
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp),
                elevation = FloatingActionButtonDefaults.elevation(15.dp),
                shape = RoundedCornerShape(60.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "FAB",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    )
}

@Composable
fun BtnRow(text: String, alignment: Arrangement.Horizontal = Arrangement.End) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = alignment,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 20.dp)
    ) {
        Btn(text = text)
    }
}

@Composable
fun ListOfPosts(posts: List<FakePost>) {
    repeat(10) {
        for (post in posts) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .clickable { }
            ) {
                Icon(
                    imageVector = Icons.Filled.FiberManualRecord,
                    contentDescription = null,
                    Modifier
                        .size(29.dp)
                        .padding(end = 20.dp),
                    tint = CustomColors.primary
                )
                Text(
                    text = post.position,
                    Modifier.padding(end = 20.dp),
                    color = CustomColors.primary,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = post.date, fontWeight = FontWeight.Normal)
            }
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 200.dp))
}