package com.techtribeservices.goalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techtribeservices.goalsapp.models.Goal
import com.techtribeservices.goalsapp.ui.theme.GoalsAppTheme
import com.techtribeservices.goalsapp.repository.GoalsService.goals

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoalsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
    CardList()
                }
            }
        }
    }
}

@Composable
fun CardList(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            AppTitle()
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = modifier.padding(innerPadding)
        ) {
            items(goals) {
                CardItem(goal = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTitle(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
        Text(text = "30 Days Goals",
            textAlign = TextAlign.Center)
    },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ))
}

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    goal: Goal
) {
    Card(modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
                .sizeIn(minHeight = 100.dp)
        ) {
            Text(text = stringResource(id = goal.day),
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(vertical = 8.dp)
            )

            Text(text = stringResource(id = goal.title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                modifier = modifier.padding(bottom = 8.dp))

            Image(
                modifier = modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                painter = painterResource(id = goal.image), contentDescription = "${goal.title}",
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.TopCenter)

            Spacer(modifier = modifier.height(5.dp))

            Text(text = stringResource(id = goal.description), 
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoalsAppTheme {
        // CardItem(goal = goals[0])
        CardList()
    }
}