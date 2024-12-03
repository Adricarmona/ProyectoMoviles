package com.example.proyectomoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.model.Rutas
import com.example.proyectomoviles.ui.viewmodels.LlantasViewModel
import com.example.proyectomoviles.ui.AcercaDe
import com.example.proyectomoviles.ui.Ayuda
import com.example.proyectomoviles.ui.LlantasScreen
import com.example.proyectomoviles.ui.Principal
import com.example.proyectomoviles.ui.auth.inicioSesion
import com.example.proyectomoviles.ui.auth.registrarseSesion

class MainActivity : ComponentActivity() {
    private val viewModel: LlantasViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoMovilesTheme {
                AppNavigation()
            }
        }
    }
    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()
        val llantasViewModel: LlantasViewModel by viewModels()

        NavHost(
            navController = navController,
            startDestination = Rutas.Principal.route
        ) {
            composable(Rutas.Principal.route) { Principal(navController) }
            composable(Rutas.Ayuda.route) { Ayuda(navController) }
            composable(Rutas.AcercaDe.route) { AcercaDe(navController) }
            composable(Rutas.Configuracion.route) { Configuracion(navController) }
            composable(Rutas.LlantasAPI.route) { LlantasScreen(llantasViewModel, navController) }
            composable(Rutas.Login.route) { inicioSesion(navController) }
            composable(Rutas.Register.route) { registrarseSesion(navController) }
        }
    }
}