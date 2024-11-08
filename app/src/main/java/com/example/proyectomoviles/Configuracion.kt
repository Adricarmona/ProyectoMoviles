package com.example.proyectomoviles

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectomoviles.ui.theme.EsteticaTitulo
import com.example.proyectomoviles.ui.theme.TipografiaTitulo

@Composable
fun configuracion() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        )
    {
        EsteticaTitulo(
            context.getString(R.string.Configuracion),
            TipografiaTitulo.bodyLarge,
            Modifier.width(350.dp)
        )
        Text(
            text = "notificaciones (check box)"
        )
        Text(
            text = "Subscribirse a correo"
        )
        Text(
            text = "enviar feedback"
        )
        Text(
            text = "aceptar seguridad datos (swiches)"
        )
        Text(
            text = "aceptar privacidad(swiches) si este y el otro se aceptan salta un toast sino otro"
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewConfiguracion() {
    ProyectoMovilesTheme{
        configuracion()
    }
}