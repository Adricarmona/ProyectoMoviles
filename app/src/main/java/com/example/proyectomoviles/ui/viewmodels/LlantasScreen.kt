package com.example.proyectomoviles.ui.viewmodels

import android.content.res.Configuration
import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.proyectomoviles.ProyectoMovilesTheme
import com.example.proyectomoviles.model.llantas.LlantasViewModel
import com.example.proyectomoviles.ui.theme.TipografiaTitulo
import com.example.proyectomoviles.ui.usables.CardDatosLLantas
import com.example.proyectomoviles.ui.usables.EsteticaTitulo
import kotlin.getValue
import kotlin.math.log

@Composable
fun LlantasScreen(viewModel: LlantasViewModel, navController: NavController) {
    val llantas by viewModel.llantas.observeAsState(emptyList())
    Log.i("palplalaplapal", llantas.toString())

    LaunchedEffect(Unit) {
        viewModel.fetchLlantas()
    }

    Column {
        EsteticaTitulo(
            text = "Nuestro Catalogo",
            style = TipografiaTitulo.bodyLarge
        )
        if (llantas.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
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

