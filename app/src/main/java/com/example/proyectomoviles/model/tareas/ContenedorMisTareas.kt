package com.example.proyectomoviles.model.tareas

import android.content.Context

class ContenedorMisTareas(context: Context) {
    private val database = BaseDatosMisTareas.obtenerInstancia(context)
    val repositorio: RepositorioMisTareas by lazy { RepositorioMisTareas(database.daoMisTareas()) }
}