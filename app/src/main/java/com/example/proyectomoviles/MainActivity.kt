package com.example.proyectomoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.proyectomoviles.ui.viewmodels.LlantasViewModel
import com.example.proyectomoviles.ui.navigationdrawer.NavigationDrawer
import com.example.proyectomoviles.ui.viewmodels.AuthViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoMovilesTheme {
                NavigationDrawer()
            }
        }
    }

}