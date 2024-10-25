package com.example.proyectomoviles

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
fun AcercaDe() {
    Text(
        text = "AcercaDe"
    )
    Image(
        painter = painterResource(R.drawable.llantaoznegra),
        contentDescription = "Llanta de coche oz negra"
    )
}