package com.example.proyectomoviles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.core.provider.FontsContractCompat.Columns
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectomoviles.ui.theme.Pink80
import com.example.proyectomoviles.ui.theme.ProyectoMovilesTheme
import com.example.proyectomoviles.ui.theme.Purple80
import com.example.proyectomoviles.ui.theme.PurpleGrey40

@Composable
fun AcercaDe() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Pink80),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "AcercaDe",
                color = PurpleGrey40,
            )
            Image(
                painter = painterResource(R.drawable.llantaoznegra),
                contentDescription = "Llanta de coche oz negra"
            )
        }
    }
}

@Preview
@Composable
fun previewAcercaDe() {
    ProyectoMovilesTheme{
        AcercaDe()
    }
}

