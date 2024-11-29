package com.example.proyectomoviles.ui.viewmodels

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.proyectomoviles.model.cocktail.LlantasViewModel

@Composable
fun LlantasScreen(viewModel: LlantasViewModel) {
    val llantas by viewModel.llantas.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchLlantas()
    }

    Column {
        if (llantas.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn{
                items(llantas) { creditCard ->
                    Text(text = llantas)
                    Text(text = creditCard.number)
                    Text(text = creditCard.type)
                    HorizontalDivider() // Add a divider between items
                }
            }
        }
    }
}