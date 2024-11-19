package com.example.proyectomoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.model.Rutas

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