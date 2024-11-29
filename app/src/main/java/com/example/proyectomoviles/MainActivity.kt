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
import com.example.proyectomoviles.model.llantas.LlantasViewModel
import com.example.proyectomoviles.ui.viewmodels.AcercaDe
import com.example.proyectomoviles.ui.viewmodels.Ayuda
import com.example.proyectomoviles.ui.viewmodels.LlantasScreen
import com.example.proyectomoviles.ui.viewmodels.Principal

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
        }
    }
}