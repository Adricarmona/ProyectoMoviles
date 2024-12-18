package com.example.proyectomoviles.model.tareas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MiTarea::class], version = 1, exportSchema = false)
abstract class BaseDatosMisTareas : RoomDatabase() {
    abstract fun daoMisTareas(): DaoMisTareas

    companion object {
        @Volatile
        private var INSTANCE: BaseDatosMisTareas? = null

        fun obtenerInstancia(context: Context): BaseDatosMisTareas {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = BaseDatosMisTareas::class.java,
                    "tareas_database"
                )
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}