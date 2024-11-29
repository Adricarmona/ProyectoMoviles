package com.example.proyectomoviles.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyectomoviles.R
import com.example.proyectomoviles.ui.usables.EsteticaMiniTitulo
import com.example.proyectomoviles.ui.usables.EsteticaTitulo
import com.example.proyectomoviles.ui.usables.TextoNormal
import com.example.proyectomoviles.ui.theme.TipografiaMiniTitulo
import com.example.proyectomoviles.ui.theme.TipografiaTitulo

@Composable
fun Ayuda(navController: NavHostController) {
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        EsteticaTitulo(
            context.getString(R.string.Ayuda),
            TipografiaTitulo.bodyLarge
        )
        Spacer(
            Modifier.size(20.dp)
        )
        Image(
            painter = painterResource(R.drawable.png_clipart_rim_et_keskin_tuning_europe_gmbh_car_tuning_alloy_wheel_kt_miscellaneous_auto_part) ,
            contentDescription = "es una foto de una llanta to guapa"
        )
        Spacer(
            Modifier.size(20.dp)
        )
        TextoNormal(
            text = context.getString(R.string.Ayudatxt) +
                    "\n\n"
        )
        EsteticaMiniTitulo(
            text = context.getString(R.string.FAQtxt) + "\n",
            TipografiaMiniTitulo.bodyLarge
        )
        TextoNormal(
            text = context.getString(R.string.BuscarLlantasTxt) +
                    "\n" +
                    context.getString(R.string.RealizarCompraTxt) +
                    "\n" +
                    context.getString(R.string.MetodosEnvioTxt) +
                    "\n" +
                    context.getString(R.string.DevolucionesTxt) +
                    "\n" +
                    context.getString(R.string.ContactoTxt) +
                    "\n" +
                    context.getString(R.string.ConsejosCompraTxt)
        )
    }

}
/*@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewAyuda() {
    ProyectoMovilesTheme{
        Ayuda()
    }
}*/
