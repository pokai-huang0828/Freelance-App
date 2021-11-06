package com.example.freelance_app.view.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.freelance_app.utils.CustomColors
import androidx.compose.material.icons.filled.FiberManualRecord
import com.example.freelance_app.ui.theme.fontSizeLarge
import com.example.freelance_app.view.reusables.Avatar
import com.example.freelance_app.view.reusablesv2.Btn
import com.example.freelance_app.view.reusablesv2.CustomField


data class FakePost(
    val position: String,
    val date: String
)

@ExperimentalAnimationApi
@Composable
fun CompanyMainPageScreen(toPostScreen: () -> Unit) {
    var btnClicked by remember { mutableStateOf(false) }
    val posts: List<FakePost> = listOf(
        FakePost(date = "Nov 5, 2021", position = "Mover"),
        FakePost(date = "Nov 5-6, 2021", position = "Dishwasher"),
        FakePost(date = "Nov 7, 2021", position = "Cleaner"),
    )
    Scaffold(
        topBar = { UserDetailsForCompanyScreenTopBar() },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 20.dp)
                ) {
                    Avatar(
                        imageUrl = "http://images.squarespace-cdn.com/content/v1/54f8c792e4b03ea829c79558/1544727583704-XD2KF76CBRCUXRQVD9K1/breka+logo+1x1+transparent.png",
                    )
                }
                Text(
                    text = "About Company:",
                    color = Color.Black,
                    fontSize = fontSizeLarge,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 20.dp)
                )
                if (btnClicked) {
                    CustomField(
                        text = "n 2010, FRESH Bakery opened its first kiosk location in Towson, Maryland. From its inception, FRESH Bakery is known as bakery unique for our square cupcakes and cakes. We take pride in using natural ingredients in our cupcakes, cakes and desserts. ",
                    )
                    BtnRow(text = "Save") {
                        btnClicked = false
                    }
                } else {
                    CustomField(
                        text = "n 2010, FRESH Bakery opened its first kiosk " +
                                "location in Towson, Maryland. From its " +
                                "inception, FRESH Bakery is known as bakery " +
                                "unique for our square cupcakes and cakes. " +
                                "We take pride in using natural ingredients " +
                                "in our cupcakes, cakes and desserts. ",
                        switch = false,
                        bgColor = Color.White,
                        textColor = Color.Black
                    )
                    BtnRow(text = "Edit") {
                        btnClicked = true
                    }
                }
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
fun BtnRow(
    text: String,
    alignment: Arrangement.Horizontal = Arrangement.End,
    clickedBtn: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = alignment,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 20.dp)
    ) {
        Btn(text = text) { clickedBtn() }
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