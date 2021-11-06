package com.example.freelance_app.view.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.freelance_app.R
import com.example.freelance_app.data.dto.Company
import com.example.freelance_app.data.dto.Job
import com.example.freelance_app.data.dto.Rating
import com.example.freelance_app.data.dto.Status
import com.example.freelance_app.ui.theme.*
import com.example.freelance_app.view.reusables.CustomButton
import com.example.freelance_app.view.reusables.RatingBox
import com.example.freelance_app.view.reusables.SearchBar
import java.util.*

val jobs: List<Job> = listOf(
    Job(
        id = 1,
        company = Company(
            id = 1,
            name = "ABC Company",
            description = "Good Company",
            logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-6ElaNy55lU4TzRca41kHkW_PVQ9K6hA2tw&usqp=CAU"
        ),
        position = "Dish Washer",
        description = "We urgently need help on August 13th , 2021, 1pm - 5pm.",
        payInHour = 15.5f,
        status = Status.ONGOING,
        category = "IT"
    ),
    Job(
        id = 1,
        company = Company(
            id = 1,
            name = "ABC Company",
            description = "Good Company",
            logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-6ElaNy55lU4TzRca41kHkW_PVQ9K6hA2tw&usqp=CAU"
        ),
        position = "Coder",
        description = "We urgently need help on August 13th , 2021, 1pm - 5pm.",
        payInHour = 15.5f,
        status = Status.ONGOING,
    ),
    Job(
        id = 1,
        company = Company(
            id = 1,
            name = "ABC Company",
            description = "Good Company",
            logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-6ElaNy55lU4TzRca41kHkW_PVQ9K6hA2tw&usqp=CAU"
        ),
        position = "Baker",
        description = "We urgently need help on August 13th , 2021, 1pm - 5pm.",
        payInHour = 15.5f,
        status = Status.ONGOING,
    ),
)

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
//fun UserPostsScreen(navController: NavController) {
fun UserPostsScreen() {
    Scaffold(
        topBar = { UserPostsScreenTopBar() },
        content = {
            UserPostsContent()
        }
    )
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun UserPostsContent() {
    var searchTerm by remember { mutableStateOf("") }
    val originPosts by remember { mutableStateOf(jobs) }
    var displayPosts by remember { mutableStateOf(jobs) }

    Column(
        modifier = Modifier
            .padding(horizontal = marginMed)
    ) {
        // Screen Title
        Text(
            text = "New Job Posts",
            color = Color.Black,
            fontSize = fontSizeLarge,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = marginSmall)
        )

        // search bar
        SearchBar() { searchText ->
            displayPosts = originPosts

            displayPosts = displayPosts.filter {
                it.position.contains(searchText, ignoreCase = true)
            }
        }

        // category picker
        CategoryPicker() {
            // filter by category
            displayPosts = originPosts
            searchTerm = it

            if (searchTerm != "All") {
                displayPosts = displayPosts.filter {
                    it.category == searchTerm
                }
            }
        }

        // jobs
        JobPosts(displayPosts)
    }
}

val categories: List<String> = listOf(
    "Food", "Business", "Education", "Services", "IT", "All"
)

@ExperimentalFoundationApi
@Composable
fun CategoryPicker(onPick: (category: String) -> Unit) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(categories.size) {
            CategoryPill(categories[it]) {
                onPick(it)
            }
        }
    }
}

@Composable
fun CategoryPill(category: String, onPress: (catergory: String) -> Unit) {
    Text(
        text = category,
        color = Color.White,
        modifier = Modifier
            .padding(marginSmall)
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colors.primary)
            .padding(marginSmall)
            .clickable { onPress(category) },
        textAlign = TextAlign.Center
    )
}

@Composable
fun JobPosts(displayPosts: List<Job>) {
    if (displayPosts.isEmpty()) {
        Text("No new posts.")
    } else {
        LazyColumn() {
            items(displayPosts.size) {
                JobPost(displayPosts[it])
            }
        }
    }
}

@Composable
fun JobPost(job: Job) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(marginMed)
            .border(1.dp, Color.Black)
            .padding(horizontal = marginLarge)
    ) {
        JobPostTitle(job)

        // Job Description
        Text(
            text = job.description,
            color = Color.Black,
            textAlign = TextAlign.Start
        )

        // PayGrade and Apply Button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = marginMed)
        ) {
            Text(
                text = "$${job.payInHour}/hour",
                color = Color.Black,
                textAlign = TextAlign.Start
            )

            CustomButton(onClick = {}) {
                Text(text = "Apply")
            }
        }
    }
}

@Composable
fun JobPostTitle(job: Job) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = job.company.name,
                color = Color.Black,
                fontSize = fontSizeMed,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )
            Text(
                text = job.position,
                color = Color.Black,
                textAlign = TextAlign.Start
            )
        }

        // Company logo
        Image(
            painter = rememberImagePainter(data = job.company.logo),
            contentDescription = "",
            modifier = Modifier
                .size(avatarSize)
                .aspectRatio(1f)
                .offset(x = -marginLarge)
        )
    }

}

@ExperimentalAnimationApi
@Composable
fun UserPostsScreenTopBar(
    navController: NavController? = null,
) {
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
            Image(
                painter = painterResource(id = R.drawable.logo_onlytext),
                contentDescription = "logo_text only",
                modifier = Modifier.size(200.dp)
            )
            Row(
                modifier = Modifier
                    .height(60.dp)
                    .padding(2.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                if (navController != null) {
                IconButton(
//                        onClick = { navController.popBackStack() },
                    onClick = { },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(45.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.History,
                        contentDescription = "History",
                        tint = White,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
                IconButton(
//                        onClick = { navController.popBackStack() },
                    onClick = { },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(45.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "AccountCircle",
                        tint = White,
                        modifier = Modifier
                            .size(30.dp)
                    )
//                    }
                }
            }
        }
    }
}




