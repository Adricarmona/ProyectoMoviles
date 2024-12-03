package com.example.proyectomoviles.ui.auth

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectomoviles.ProyectoMovilesTheme

@Composable
fun registrarseSesion(navController: NavController){
    var usuario = remember { mutableStateOf("") }
    var clave = remember { mutableStateOf("") }
    var resultado = remember {mutableStateOf("Sin resultado")}

    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Registrarse",
            color = MaterialTheme.colorScheme.primary
        )
        OutlinedTextField(
            value = usuario.value,
            onValueChange = { it ->
                usuario.value = it
            },
            label = {
                Text(text = "Nombre de usuario")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )
        OutlinedTextField(
            value = clave.value,
            onValueChange = { it ->
                clave.value = it
            },
            label = {
                Text(text = "Contraseña usuario")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
            visualTransformation =  PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        Button(
            onClick = { Toast.makeText(context, "aaaa", Toast.LENGTH_SHORT).show(); }
        ){
                Text("Registrarse")
            }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewDatos() {
    ProyectoMovilesTheme{
        registrarseSesion(navController = NavController(context = LocalContext.current))
    }
}
