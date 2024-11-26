package com.example.proyectomoviles

import android.app.Activity
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.model.Rutas

@Composable
fun Principal(navController: NavController) {
    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(
            painter = painterResource(R.drawable.ecoring),
            contentDescription = "icono ecoring",
        )
        Spacer(modifier = Modifier.height(80.dp))

        Cards(
            "🆘"+context.getString(R.string.ayuda),
            { navController.navigate(Rutas.Ayuda.route) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Cards(
            "👬"+context.getString(R.string.AcercaDe),
            { navController.navigate(Rutas.AcercaDe.route) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Cards(
            "🛠"+context.getString(R.string.configuracion),
            { navController.navigate(Rutas.Configuracion.route) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Cards(
            "🚪"+context.getString(R.string.salir),
            { openDialog.value = true }
        )

        if (openDialog.value) {
            AlertDialogDoc(openDialog)
        }
    }
}

@Composable
fun AlertDialogDoc(openDialog: MutableState<Boolean>) {
    val context = LocalContext.current
    val activity = context as? Activity
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = context.getString(R.string.salirAplicacion))
            },
            text = {
                Text(
                    context.getString(R.string.SeguroDeSalir)
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        activity?.finishAffinity()
                    }
                ) {
                    Text(context.getString(R.string.aceptar))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text(context.getString(R.string.cancelar))
                }
            }
        )
    }
}

@Composable
fun Cards(
    texto: String,
    onclick: () -> Unit
){
    Card(
        onClick = onclick,
        modifier = Modifier.size(width = 200.dp, height = 40.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        elevation = CardDefaults.cardElevation(8.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = texto,
            )
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewAyuda() {
    ProyectoMovilesTheme{
        Principal(navController = rememberNavController())
    }
}