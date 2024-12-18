package com.example.proyectomoviles.model.tareas

import kotlinx.coroutines.flow.Flow

class RepositorioMisTareas(private val dao: DaoMisTareas) {
    val todasLasTareas: Flow<List<MiTarea>> = dao.obtenerTodasLasTareas()

    suspend fun agregarTarea(tarea: MiTarea) {
        dao.insertarTarea(tarea)
    }

    suspend fun borrarTarea(tarea: MiTarea) {
        dao.eliminarTarea(tarea)
    }
}