package com.example.proyectomoviles

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun Ayuda() {
    val text: String
    Text(
        text = "hola"
    )
    Image(
        painter = painterResource(R.drawable.png_clipart_rim_et_keskin_tuning_europe_gmbh_car_tuning_alloy_wheel_kt_miscellaneous_auto_part) ,
        contentDescription = "es una foto de una llanta to guapa"
    )
}
