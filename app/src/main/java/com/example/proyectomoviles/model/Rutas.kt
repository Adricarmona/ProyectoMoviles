package com.example.proyectomoviles.model

sealed class Rutas(val route: String) {
    object Principal : Rutas("principal")
    object Ayuda : Rutas("ayuda")
    object AcercaDe : Rutas("acerca_de")
    object Configuracion : Rutas("configuracion")
    object LlantasAPI : Rutas("llantasApi")
    object Login : Rutas("inicioSession")
    object Register : Rutas("registrarseSesion")
    object Perfil : Rutas("perfil")
}