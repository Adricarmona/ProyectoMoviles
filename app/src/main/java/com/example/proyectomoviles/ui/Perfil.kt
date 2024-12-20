package com.example.proyectomoviles.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyectomoviles.R
import com.example.proyectomoviles.model.Rutas
import com.example.proyectomoviles.ui.theme.TipografiaTitulo
import com.example.proyectomoviles.ui.usables.EsteticaTitulo
import com.example.proyectomoviles.ui.usables.TextoNormal
import com.example.proyectomoviles.ui.viewmodels.AuthState
import com.example.proyectomoviles.ui.viewmodels.AuthViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun Perfil(navController: NavHostController, authViewModel: AuthViewModel) {
    val context = LocalContext.current
    val authState = authViewModel.authState.observeAsState()
    val user = Firebase.auth.currentUser
    val email = user?.email

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        EsteticaTitulo(
            text = context.getString(R.string.perfil),
            style = TipografiaTitulo.bodyLarge,
            modifier = Modifier.padding(0.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        when (authState.value) {
            is AuthState.Authenticated -> {
                TextoNormal(
                    text = email ?: "Correo no disponible",
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                TextButton(
                    onClick = {
                        authViewModel.signout()
                        navController.navigate(Rutas.Principal.route)
                              },
                    modifier = Modifier.padding(10.dp, 5.dp, 0.dp, 0.dp),
                    shape = MaterialTheme.shapes.extraSmall
                ) {
                    Text(text = "❌"+context.getString(R.string.cerrarsesion)+"❌")
                }
            }
            else -> {
                Text(text = context.getString(R.string.noestasautenticado))
            }
        }
    }
}
