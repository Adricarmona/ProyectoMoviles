package com.example.proyectomoviles

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.proyectomoviles.ui.theme.EsteticaTitulo
import com.example.proyectomoviles.ui.theme.TextoNormal
import com.example.proyectomoviles.ui.theme.TipografiaTitulo
import com.example.proyectomoviles.ui.theme.Typography

@Composable
fun AcercaDe() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.iconoecoring),
                contentDescription = "icono aplicacion",
                modifier = Modifier.width(250.dp)
            )
            Spacer(
                Modifier.size(20.dp)
            )

            /*
            Parte de arriba debajo del icono con el titulo y el subtitulo gigantico
             */
            EsteticaTitulo(
                context.getString(R.string.AcercaDe),
                TipografiaTitulo.bodyLarge
            )
            EsteticaTitulo(
                "EcoRing",
                TipografiaTitulo.bodyLarge
            )
            TextoNormal(
                context.getString(R.string.TrabajoDeMoviles),
                Modifier.width(250.dp)
            )

            /// ESPACIO ENTRE TITULO Y TEXTO
            Spacer(
                Modifier.height(40.dp)
            )
            /// ESPACIO ENTRE TITULO Y TEXTO


            // el quienes aparecemos en la aplicacion
            TextoNormal(
                context.getString(R.string.AplicacionCreada),
                Modifier.width(250.dp)
            )
            TextoNormal(
                "- Adrian Carmona",
                Modifier.width(250.dp)
            )
            TextoNormal(
                "- Hector Dominguez",
                Modifier.width(250.dp)
            )

            Spacer(
                Modifier.height(20.dp)
            )

            Text(
                text = "Version 0.1",
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewAcercaDe() {
    ProyectoMovilesTheme{
        AcercaDe()
    }
}
