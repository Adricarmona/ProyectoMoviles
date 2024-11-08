package com.example.proyectomoviles.ui.theme

import android.R
import android.graphics.Paint
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun EsteticaTitulo(text: String, style: TextStyle, modifier: Modifier = Modifier.width(250.dp))
{
    Text(
        text = text,
        color = MaterialTheme.colorScheme.primary,
        style = style,
        modifier = modifier
    )
}

@Composable
fun TextoNormal(text: String)
{
    Text(
        text = text,
        color = MaterialTheme.colorScheme.secondary,
        textAlign = TextAlign.Center,
        modifier = Modifier.width(250.dp)
    )
}