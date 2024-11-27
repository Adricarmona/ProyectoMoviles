package com.example.proyectomoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.model.Rutas
import com.example.proyectomoviles.ui.viewmodels.AcercaDe
import com.example.proyectomoviles.ui.viewmodels.Ayuda
import com.example.proyectomoviles.ui.viewmodels.Configuracion
import com.example.proyectomoviles.ui.viewmodels.Principal

class MainActivity : ComponentActivity() {
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

        NavHost(
            navController = navController,
            startDestination = Rutas.Principal.route
        ) {
            composable(Rutas.Principal.route) { Principal(navController) }
            composable(Rutas.Ayuda.route) { Ayuda(navController) }
            composable(Rutas.AcercaDe.route) { AcercaDe(navController) }
            composable(Rutas.Configuracion.route) { Configuracion(navController) }
        }
    }
}