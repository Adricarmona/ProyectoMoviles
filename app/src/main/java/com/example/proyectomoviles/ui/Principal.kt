package com.example.proyectomoviles.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectomoviles.R
import com.example.proyectomoviles.model.Rutas
import com.example.proyectomoviles.ui.usables.AlertDialogDoc
import com.example.proyectomoviles.ui.viewmodels.AuthState
import com.example.proyectomoviles.ui.viewmodels.AuthViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

@Composable
fun Principal(navController: NavController, authViewModel: AuthViewModel) {
    val context = LocalContext.current
    val authState = authViewModel.authState.observeAsState()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painter = painterResource(R.drawable.ecoring),
                contentDescription = "icono ecoring",
            )
            Spacer(modifier = Modifier.height(80.dp))
            Cards(
                "🦽"+context.getString(R.string.llantas),
                { navController.navigate(Rutas.LlantasAPI.route) }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Cards(
                "🗒"+context.getString(R.string.Notas),
                { navController.navigate(Rutas.Tareas.route) }
            )
            Spacer(modifier = Modifier.height(8.dp))
            when(authState.value) {
                AuthState.Authenticated -> {
                    Cards(
                        "💻"+context.getString(R.string.perfil),
                        { navController.navigate(Rutas.Perfil.route) }
                    )
                }
                else -> {
                    Cards(
                        "👨‍💻"+context.getString(R.string.iniciarsesion),
                        { navController.navigate(Rutas.Login.route) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Cards(
                "🆘"+context.getString(R.string.ayuda),
                { navController.navigate(Rutas.Ayuda.route) }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Cards(
                "👬"+context.getString(R.string.AcercaDe),
                { navController.navigate(Rutas.AcercaDe.route) }
            )
        }
    }


@Composable
fun Cards(
    texto: String,
    onclick: () -> Unit
){
    Card(
        onClick = onclick,
        modifier = Modifier.size(width = 200.dp, height = 40.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        elevation = CardDefaults.cardElevation(8.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = texto,
            )
        }
    }
}

/*@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewAyuda() {
    ProyectoMovilesTheme{
        Principal(navController = rememberNavController())
    }
}*/