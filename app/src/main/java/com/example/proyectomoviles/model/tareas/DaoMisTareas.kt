package com.example.proyectomoviles.model.tareas

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface DaoMisTareas {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTarea(tarea: MiTarea)

    @Delete
    suspend fun eliminarTarea(tarea: MiTarea)

    @Query("SELECT * FROM tabla_tareas")
    fun obtenerTodasLasTareas(): Flow<List<MiTarea>>
}