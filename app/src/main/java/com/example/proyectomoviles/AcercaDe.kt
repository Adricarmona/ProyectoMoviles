package com.example.proyectomoviles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.core.provider.FontsContractCompat.Columns
import java.lang.reflect.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.Color


@Composable
fun AcercaDe() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(if (isSystemInDarkTheme())primaryLightMediumContrast else primaryContainerLight),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "AcercaDe"
            )
            Image(
                painter = painterResource(R.drawable.llantaoznegra),
                contentDescription = "Llanta de coche oz negra"
            )
        }
    }
}