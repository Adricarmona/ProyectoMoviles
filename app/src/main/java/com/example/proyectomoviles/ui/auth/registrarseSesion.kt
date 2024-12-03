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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectomoviles.ProyectoMovilesTheme
import com.example.proyectomoviles.model.Rutas
import com.example.proyectomoviles.ui.viewmodels.AuthState
import com.example.proyectomoviles.ui.viewmodels.AuthViewModel

@Composable
fun registrarseSesion(navController: NavController, authViewModel: AuthViewModel){
    var usuario by remember { mutableStateOf("") }
    var clave by remember { mutableStateOf("") }
    var resultado = remember {mutableStateOf("Sin resultado")}
    val authState = authViewModel.authState.observeAsState()
    var context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate(Rutas.Principal.route)
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }



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
            value = usuario,
            onValueChange = { it ->
                usuario = it
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
            value = clave,
            onValueChange = { it ->
                clave = it
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
            onClick = {
                authViewModel.signup(usuario, clave)
            }
        ){
                Text("Registrarse")
            }
    }
}

/*@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewDatos() {
    ProyectoMovilesTheme{
        registrarseSesion(navController = NavController(context = LocalContext.current))
    }
}*/
