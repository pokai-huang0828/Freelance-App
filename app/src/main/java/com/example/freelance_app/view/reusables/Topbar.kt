@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.freelance_app.view.reusables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@ExperimentalAnimationApi
@Composable
fun TopBar() {
//    var visible by remember { mutableStateOf(false) }
    Column(Modifier.shadow(elevation = 5.dp)) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .fillMaxWidth()
                .height(60.dp)
                .padding(vertical = 3.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            IconButton(
//                onClick = {
//                    scope.launch {
//                        scaffoldState.drawerState.open()
//                    }
//                }) {
//                Icon(
//                    Icons.Filled.Menu,
//                    contentDescription = "",
//                    tint = Color.White
//                )
//            }

            Image(
                painter = painterResource(id = com.example.freelance_app.R.drawable.logo_onlytext),
                contentDescription = "",
                modifier = Modifier.size(200.dp)
            )

            Row(
                modifier = Modifier
                    .height(60.dp)
                    .padding(2.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

//                IconButton(
//                    onClick = { visible = !visible },
//                    modifier = Modifier
//                        .padding(5.dp)
//                        .size(45.dp)
//                        .clip(CircleShape)
//                ) {
//                    Icon(
//                        imageVector = Icons.Filled.Search,
//                        contentDescription = "Search",
//                        tint = Color.White,
//                        modifier = Modifier
//                            .size(30.dp)
//                    )
//                }

//                IconButton(
//                    onClick = { auth.signOut(navController) },
//                    modifier = Modifier
//                        .padding(5.dp)
//                        .size(45.dp)
//                        .clip(CircleShape)
//                ) {
//                    Icon(
//                        imageVector = Icons.Filled.ExitToApp,
//                        contentDescription = "Logout",
//                        tint = White,
//                        modifier = Modifier
//                            .size(28.dp)
//                    )
//                }
            }
        }
    }
}