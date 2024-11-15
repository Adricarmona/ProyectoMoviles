package com.example.proyectomoviles.ui.theme

import android.R
import android.content.Context
import android.graphics.Paint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.proyectomoviles.ProyectoMovilesTheme


@Composable
fun EsteticaTitulo(text: String, style: TextStyle, modifier: Modifier = Modifier.width(250.dp))
{
    ProyectoMovilesTheme {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.primary,
            style = style,
            modifier = modifier
        )
    }
}

@Composable
fun EsteticaMiniTitulo(text: String, style: TextStyle, modifier: Modifier = Modifier.width(375.dp))
{
    ProyectoMovilesTheme {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.primary,
            style = style,
            modifier = modifier
        )
    }
}

@Composable
fun TextoNormal(text: String, modifier: Modifier =Modifier.width(500.dp))
{
    ProyectoMovilesTheme {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Composable
fun SwitchYTexto(text: String, variable: Boolean)
{
    ProyectoMovilesTheme {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Switch(
                checked = variable,
                onCheckedChange = { variable = !variable },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                    uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                    uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer
                )
            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text(
                text = text,
                color = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}

@Composable
fun CheckboxYTexto(text: String, variable: MutableState<Boolean>)
{
    ProyectoMovilesTheme {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = variable.value,
                onCheckedChange = { variable.value = it }
            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text(
                text = text,
                color = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}
