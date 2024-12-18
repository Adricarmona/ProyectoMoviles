package com.example.proyectomoviles.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.proyectomoviles.model.tareas.MiTarea

@Composable
fun Tareas(
    listaTareas: List<MiTarea>,
    onAgregarTarea: (String, String) -> Unit,
    onEliminarTarea: (MiTarea) -> Unit
) {
    val context = LocalContext.current
    var nombreTarea by remember { mutableStateOf("") }
    var descripcionTarea by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nombreTarea,
            onValueChange = { nombreTarea = it },
            label = { Text(text = context.getString(R.string.nombre_tarea)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = descripcionTarea,
            onValueChange = { descripcionTarea = it },
            label = { Text(text = context.getString(R.string.descripcion_tarea)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                onAgregarTarea(nombreTarea, descripcionTarea)
                nombreTarea = ""
                descripcionTarea = ""
            }
        ) {
            Text(text = context.getString(R.string.agregar_tarea))
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(listaTareas) { tarea ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = tarea.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(text = tarea.descripcion, style = MaterialTheme.typography.bodyMedium)
                        }
                        IconButton(onClick = { onEliminarTarea(tarea) }) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}