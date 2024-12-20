package com.example.proyectomoviles.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyectomoviles.ui.viewmodels.HomeViewModel

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory) // ..1
) {
    val friendsList by viewModel.getAll().collectAsState(initial = emptyList()) // ..2
    var friendNameInput by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the list of friends
        LazyColumn(
            modifier = Modifier.weight(.7F),
            verticalArrangement = Arrangement.Center
        ) {
            items(friendsList) { friend ->
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(80.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = friend.name, style = MaterialTheme.typography.displaySmall)
                    }
                }
            }
        }

        // Input field and buttons
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(.3F)
        ) {
            OutlinedTextField(value = friendNameInput, onValueChange = { friendNameInput = it })
            Button(onClick = { viewModel.insertFriend(friendNameInput) }) {
                Text(text = "SAVE")
            }
            Button(onClick = { viewModel.deleteAllMyFriends(friendsList) }) {
                Text(text = "ALL DELETE")
            }
        }
    }
}