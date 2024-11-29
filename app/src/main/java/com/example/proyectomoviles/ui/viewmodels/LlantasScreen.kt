package com.example.proyectomoviles.ui.viewmodels

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.proyectomoviles.model.llantas.LlantasViewModel

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
                items(llantas) { llanta ->
                    Text(text = llanta.brand)
                    Text(text = llanta.model)
                    Text(text = llanta.size)
                    HorizontalDivider()

                }
            }
        }
    }
}