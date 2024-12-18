package com.example.proyectomoviles.model.tareas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_tareas")
data class MiTarea(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "descripcion") val descripcion: String,
    @ColumnInfo(name = "completada") val completada: Boolean = false
)
