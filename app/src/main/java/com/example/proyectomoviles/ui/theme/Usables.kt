package com.example.proyectomoviles.ui.theme

import android.R
import android.graphics.Paint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
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

@Composable
fun RadioButonYTexto(text: String, variable: MutableState<Boolean>)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        RadioButton(
            selected = variable.value,
            onClick = {variable.value = !variable.value},
        )
        Text(
            text = text
        )
    }
}