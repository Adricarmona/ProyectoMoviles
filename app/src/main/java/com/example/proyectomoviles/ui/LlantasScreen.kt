package com.example.proyectomoviles.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.ProyectoMovilesTheme
import com.example.proyectomoviles.R
import com.example.proyectomoviles.ui.viewmodels.LlantasViewModel
import com.example.proyectomoviles.ui.theme.TipografiaTitulo
import com.example.proyectomoviles.ui.usables.CardDatosLLantas
import com.example.proyectomoviles.ui.usables.EsteticaTitulo

@Composable
fun LlantasScreen(viewModel: LlantasViewModel, navController: NavController) {
    val llantas by viewModel.llantas.observeAsState(emptyList())
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.fetchLlantas()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background)
        .padding(0.dp, 35.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        EsteticaTitulo(
            text = context.getString(R.string.Nuestro_Catalogo),
            style = TipografiaTitulo.bodyLarge,
            modifier = Modifier.width(400.dp)
        )
        Spacer(Modifier.height(4.dp))
        if (llantas.isEmpty()) {
            // Show loading indicator or placeholder
            Text(
                text = context.getString(R.string.Loading___),
                color = MaterialTheme.colorScheme.secondary
            )
            CircularProgressIndicator()
        } else {
            // Display the list of credit cards
            LazyColumn{
                items(llantas) { llanta ->
                    CardDatosLLantas(
                        brand = llanta.brand,
                        model = llanta.model,
                        size = llanta.size,
                        material = llanta.material,
                        color = llanta.color,
                        price = llanta.price,
                        image_url = llanta.image_url
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewLlantas() {
    ProyectoMovilesTheme{
        val llantasViewModel = LlantasViewModel()
        LlantasScreen(llantasViewModel, navController = rememberNavController())
    }
}

